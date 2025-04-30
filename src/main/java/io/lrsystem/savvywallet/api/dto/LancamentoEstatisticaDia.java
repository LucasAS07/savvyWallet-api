package io.lrsystem.savvywallet.api.dto;

import io.lrsystem.savvywallet.api.model.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoEstatisticaDia {

    private TipoLancamento tip;

    private LocalDate dia;

    private BigDecimal total;

    public LancamentoEstatisticaDia(TipoLancamento tip, LocalDate dia, BigDecimal total) {
        this.tip = tip;
        this.dia = dia;
        this.total = total;
    }

    public TipoLancamento getTip() {
        return tip;
    }

    public void setTip(TipoLancamento tip) {
        this.tip = tip;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
