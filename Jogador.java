public class Jogador{
    private string id;
    private boolean tipo; //true (1) para humano, false (0) para máquina
    private double aposta;
    private JogoDado jogoD = new JogoDado;
    private double saldo = 100;
    private boolean ganhador;

    public Jogador(String id, boolean tipo){
        this.id = id;
        this.tipo = tipo;
        this.jogoDado = new JogoDados();
    }
    
    public void jogarDados(){
        jogoD.rolarDados();
    }

    public double apostar(){
        if(tipo == 0){ //maquina
            int auxiliar = (this.saldo/5);
            this.saldo -= auxiliar;
            this.aposta = auxiliar;
            return auxiliar;
        }   
    }
    
    public double apostar(int qntDaAposta){
        if(tipo == 1){ //humano
            if((saldo > 0) && (qntDaAposta < saldo)){
                this.saldo -= qntDaAposta;
                this.aposta = qntDaAposta;
                return qntDaAposta;
            }
        }
        else if(tipo == 0){ //maquina
            if(saldo > 0){
                qntDaAposta = (this.saldo/5);
                this.saldo -= qntDaAposta;
                this.aposta = qntDaAposta;
                return qntDaAposta;
            }
        }
    }
    
    public int[] mostrarLancamentosJogo(){
        return jogoD.getResultados();
    }

    public void ganhou(double valor){
        this.saldo += valor;
    }
    
    public double getSaldo(){
        return this.saldo;
    }

    public double getAposta(){
        return this.aposta;
    }

    public String getId(){
        return this.id;
    }

    public void setGanhador(boolean ganhador){
        this.ganhador = ganhador;
    }

    public boolean isGanhador(){
        return this.ganhador;
    }
    
    public String toString(){
        return "Jogador: \n" + "Id: " + this.id + "\n" + "Tipo: " + (this.tipo ? "humano" : "maquina") + "\n" +"Saldo: " + this.saldo + "\n" + "Aposta: " + this.aposta; 
        //o ? : funciona como if else para verificar se o tipo é humano ou maquina, ja que a variavel é booleana funciona so como um true ou false
    }
}
