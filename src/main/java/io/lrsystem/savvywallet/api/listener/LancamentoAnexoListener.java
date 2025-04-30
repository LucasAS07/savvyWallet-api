package io.lrsystem.savvywallet.api.listener;

import io.lrsystem.savvywallet.api.SavvyWalletApiApplication;
import io.lrsystem.savvywallet.api.model.Lancamento;
import io.lrsystem.savvywallet.api.storage.S3;
import org.springframework.util.StringUtils;

import javax.persistence.PostLoad;

public class LancamentoAnexoListener {

    @PostLoad
    public void postLoad(Lancamento lancamento){
        if (StringUtils.hasText(lancamento.getAnexo())){
            S3 s3 = SavvyWalletApiApplication.getBean(S3.class);
            lancamento.setUrlAnexo(s3.configurarUrl(lancamento.getAnexo()));
        }
    }

}
