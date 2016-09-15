package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Flávio Coutinho <fegemo@gmail.com>
 */
public class Perseguir extends Algoritmo {

    private static final char NOME = 's';

    public Perseguir(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Perseguir(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 auxiliar = new Vector3(alvo.getObjetivo());
        output.velocidade = auxiliar.sub(agente.posicao);
        output.velocidade.setLength(maxVelocidade);

        return output;
    }

}
