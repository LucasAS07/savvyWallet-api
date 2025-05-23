package io.lrsystem.savvywallet.api.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import io.lrsystem.savvywallet.api.config.property.SavvyWalletApiProperty;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.logging.Logger;

@Component
public class S3 {

    @Autowired
    private SavvyWalletApiProperty property;

    @Autowired
    private AmazonS3 amazonS3;

    public String salvarTemporariamente(MultipartFile arquivo){

        AccessControlList acl = new AccessControlList();
        acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(arquivo.getContentType());
        objectMetadata.setContentLength(arquivo.getSize());

        String nomeUnico = gerarNomeUnido(arquivo.getOriginalFilename());

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(
                    property.getS3().getBucket(),
                    nomeUnico,
                    arquivo.getInputStream(),
                    objectMetadata
            );

            putObjectRequest.setTagging(new ObjectTagging(
                    Arrays.asList(new Tag("expirar","true"))
            ));

            amazonS3.putObject(putObjectRequest);

            return nomeUnico;
        } catch (IOException e) {
            throw new RuntimeException("Problemas ao enviar arquivo para S3" + e);
        }

    }

    public void salvar(String objeto) {
        SetObjectTaggingRequest setObjectTaggingRequest = new SetObjectTaggingRequest(
                property.getS3().getBucket(),
                objeto,
                new ObjectTagging(Collections.emptyList())
        );

        amazonS3.setObjectTagging(setObjectTaggingRequest);
    }

    public void remover(String objeto) {
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(
                property.getS3().getBucket(),
                objeto
        );

        amazonS3.deleteObject(deleteObjectRequest);
    }

    public String configurarUrl(String objeto){
        return "\\\\" + property.getS3().getBucket() + ".s3.amazonaws.com/" + objeto;
    }

    public void substituir(String objetoAntigo, String objetoNovo) {
        if (StringUtils.hasText(objetoAntigo)){
            this.remover(objetoAntigo);
        }

        salvar(objetoNovo);
    }

    private String gerarNomeUnido(String originalFilename) {
        return UUID.randomUUID().toString() + "_" + originalFilename;
    }

}
