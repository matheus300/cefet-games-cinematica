package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by matheus on 14/09/16.
 */
public class Chegar extends Algoritmo {
    private static final char NOME = 'c';
    float raio;

    public Chegar(float maxVelocidade, float raio) {
        this(NOME, maxVelocidade, raio);
    }

    protected Chegar (char nome, float maxVelocidade, float raio) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
        this.raio = raio;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 objetivo = new Vector3(alvo.getObjetivo());
        Vector3 auxiliar1 = new Vector3(objetivo);
        Vector3 auxiliar2 = new Vector3(auxiliar1);
        if (auxiliar1.sub(agente.posicao).len() < raio) {
            float x = auxiliar1.len();
            output.velocidade = auxiliar2.sub(agente.posicao).setLength(x);
        }else {
            output.velocidade = auxiliar2.sub(agente.posicao).setLength(maxVelocidade);
        }
        return output;
    }
}
