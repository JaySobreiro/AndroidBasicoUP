package br.edu.up.apppagamento;

public class Folha {

    private String nome;
    private int horasTrab;
    private float valorHora;
    private float salBruto;
    private float salLiq;
    private float ir;
    private float inss;
    private float fgts;

    public Folha(String nome, int horasTrab, float valorHora){
        this.nome = nome;
        this.horasTrab = horasTrab;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(int horasTrab) {
        this.horasTrab = horasTrab;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public float getSalBruto() {
        return salBruto;
    }

    public void setSalBruto(float salBruto) {
        this.salBruto = salBruto;
    }

    public float getSalLiq() {
        return salLiq;
    }

    public void setSalLiq(float salLiq) {
        this.salLiq = salLiq;
    }

    public float getIr() {
        return ir;
    }

    public void setIr(float ir) {
        this.ir = ir;
    }

    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public float getFgts() {
        return fgts;
    }

    public void setFgts(float fgts) {
        this.fgts = fgts;
    }

    // métodos

    // calc salário bruto
    public void calcSalBruto(){
        salBruto = (float)horasTrab * valorHora;
    }

    // calculo do IR
    public void calcIR(){

        if(salBruto <= 1372.81f){
            ir = 0;

        }else if (salBruto <= 2743.25f){
            ir = salBruto * 0.15f;

        }else{
            ir = salBruto * 0.275f;
        }
    }

    // calculo do INSS
    public void calcINSS(){

        if(salBruto <= 868.29f){
            inss = salBruto * 0.08f;

        }else if(salBruto <= 1447.14f){
            inss = salBruto * 0.09f;

        }else if (salBruto <= 2894.28f){
            inss = salBruto * 0.11f;

        }else{
            inss = 318.37f;
        }
    }

    // fgts:
    public void calcFGTS(){
        fgts = salBruto * 0.08f;
    }

    // salario liquido
    public void calcSalLiq(){
        salLiq = salBruto - ir - inss;
    }

    // chama métodos que realizam os calculos:
    public void calcSalario(){
        calcSalBruto();
        calcIR();
        calcINSS();
        calcFGTS();
        calcSalLiq();
    }
}
