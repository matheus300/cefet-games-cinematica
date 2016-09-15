package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Flávio Coutinho <fegemo@gmail.com>
 */
public class Fugir extends Algoritmo {

    private static final char NOME = 'f';

    public Fugir(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Fugir(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;

    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 auxiliar = new Vector3(alvo.getObjetivo());
        output.velocidade = auxiliar.sub(agente.posicao);
        output.velocidade.setLength(maxVelocidade);
        output.velocidade.scl(-1);

        return output;
    }

}
