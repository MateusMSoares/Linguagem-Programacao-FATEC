package org.example.testes;

import org.example.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestesExercicios {

    @Test
    // 1)
    public void testIdadeEmDias() {
        IdadeEmDIas idadeEmDias = new IdadeEmDIas(27, 5, 15);
        assertEquals((27 * 365) + (5 * 30) + 15, idadeEmDias.calculaIdadeEmDias());
    }

    @Test
    // 2)
    public void testPercentualEleitores() {
        PercentualEleitores percentualEleitores = new PercentualEleitores(1024, 524, 128);
        assertEquals(61, percentualEleitores.calculaPercentualVotosBrancos(), 0.01);
        assertEquals(31, percentualEleitores.calculaPercentualVotosNulos(), 0.01);
        assertEquals(7, percentualEleitores.calculaPercentualVotosValidos(), 0.01);
    }

    @Test
    // 3)
    public void testReajusteSalario() {
        ReajusteSalario reajusteSalario = new ReajusteSalario(5000, 5);
        assertEquals(5250.00, reajusteSalario.calculaNovoSalario(), 0.01);
    }

    @Test
    // 4)
    public void testCustoFinalCarro() {
        CustoFinalCarro custoFinalCarro = new CustoFinalCarro(150000);
        assertEquals(42000, custoFinalCarro.calculaCustoDistribuidor(), 0.01);
        assertEquals(67500, custoFinalCarro.calculaCustoImpostos(), 0.01);
        assertEquals(40500, custoFinalCarro.calculaCustoFabricacao(), 0.01);
    }

    @Test
    // 5)
    public void testSalarioVendedorCarros() {
        SalarioVendedorCarros salarioVendedorCarros = new SalarioVendedorCarros(2000, 5,
                0.02, 300000);
        assertEquals(1200, salarioVendedorCarros.calculaComissaoPorCarroVendido(), 0.01);
        assertEquals(6000,salarioVendedorCarros.calculaComissaoTotalPorCarroVendido(), 0.01);
        assertEquals(15000, salarioVendedorCarros.calculaComissaoPorValorVendido(), 0.01);
        assertEquals(23000, salarioVendedorCarros.calculaSalarioFinal(), 0.01);
    }
    @Test
    // 6)
    public void testeTransformaFahrenheitemCelcius() {
        TransformaFahrenheitemCelcius transformaFahrenheitemCelcius = new TransformaFahrenheitemCelcius(190);
        assertEquals(87.78, transformaFahrenheitemCelcius.CalculaTransformaFahrenheitemCelcius(), 0.01);
    }
    @Test
    // 7)
    public void testeSeNumeroMaiorQueDez() {
        VerificarSeNumeroMaiorQueDez verificarSeNumeroMaiorQueDez = new VerificarSeNumeroMaiorQueDez(15);
        assertTrue(verificarSeNumeroMaiorQueDez.calculaSeNumeroMaiorQueDez());
    }
    @Test
    // 8)
    public void testeNumeroPositivoOuNegativo() {
        NumeroPositivoOuNegativo numeroPositivoOuNegativo = new NumeroPositivoOuNegativo(15);
        assertTrue(numeroPositivoOuNegativo.calculaNumeroPositivoOuNegativo());
    }
    @Test
    // 9)
    public void testeCustoMacas() {
        CustoMacas custoMacas = new CustoMacas(15);
        assertEquals(15, custoMacas.calculaPrecoCompra(), 0.01);
        CustoMacas custoMacas1 = new CustoMacas(10);
        assertEquals(13, custoMacas1.calculaPrecoCompra(), 0.01);
    }
    @Test
    // 10)
    public void testaAvaliacaoAlunoAprovado() {
        AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno(7, 8);
        assertEquals(7.5, avaliacaoAluno.calculaMedia(), 0.01);
        assertTrue(avaliacaoAluno.verificaAprovacao());
    }

    @Test
    // 10)
    public void testaAvaliacaoAlunoReprovado() {
        AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno(4, 5);
        assertEquals(4.5, avaliacaoAluno.calculaMedia(), 0.01);
        assertFalse(avaliacaoAluno.verificaAprovacao());
    }

    @Test
    // 11)
    public void testaVerificaVotoCom16Anos() {
        VerificaVoto verificaVoto = new VerificaVoto(2024, 2008);
        assertTrue(verificaVoto.podeVotar());
    }

    @Test
    // 11)
    public void testaVerificaVotoComMenosDe16Anos() {
        VerificaVoto verificaVoto = new VerificaVoto(2024, 2010);
        assertFalse(verificaVoto.podeVotar());
    }

    @Test
    // 12)
    public void testaVerificaMaior() {
        VerificaMaior verificaMaior = new VerificaMaior(10, 15);
        assertEquals(15.0, verificaMaior.retornaMaior(), 0.01);
    }

    @Test
    // 13)
    public void testaEscreveOrdemCrescente() {
        EscreveOrdemCrescente escreveOrdemCrescente = new EscreveOrdemCrescente(20, 10);
        assertEquals("10.0 20.0", escreveOrdemCrescente.retornaOrdem());
    }

    @Test
    // 14)
    public void testaDuracaoJogoXadrez() {
        DuracaoJogoXadrez duracaoJogoXadrez = new DuracaoJogoXadrez(20, 5);
        assertEquals(9, duracaoJogoXadrez.calculaDuracao(), 0.01);
    }

    @Test
    // 15)
    public void testaSalarioFuncionarioSemHoraExtra() {
        SalarioFuncionario salarioFuncionario = new SalarioFuncionario(40, 10);
        assertEquals(400, salarioFuncionario.calculaSalario(), 0.01);
    }
}