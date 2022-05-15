package domain

import domain.criterios.Basico
import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {

    // ---------------------------------
    //
    //      Seu código deve vir aqui
    //
    //      Defina atributos e métodos conforme especificado
    //      no arquivo de teste encontrado em
    //      'src/test/kotlin/domain/AnalisadorDeAprovacaoTest'
    //
    // ---------------------------------
    private var criterio: CriterioDeAprovacao = Basico()
    fun defineCriterio(crit: CriterioDeAprovacao){
        this.criterio=crit
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado{
        val miniEp=boletim.mediaMiniEPs
        val mEp=boletim.mediaEPs
        val mFinal=this.criterio.mediaFinal(boletim)
        val apr=this.criterio.estaAprovado(boletim)
        return(BoletimFechado(mEp, miniEp, mFinal, apr))
    }
}