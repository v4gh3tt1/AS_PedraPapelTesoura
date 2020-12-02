package dev.smartpanda.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void selecionadoPedra(View view){
          this.opcaoSelecionada("pedra"); // obs: pode usar numeros inteiros no lugar da string
        }

        public void selecionadoPapel(View view){
            this.opcaoSelecionada("papel");
        }

        public void selecionadoTesoura(View view){
            this.opcaoSelecionada("tesoura");

    }
        public void opcaoSelecionada (String escolhaUsuario){ // se usar numeros inteiros, mudar String para 'int'


            ImageView imagemResultado = findViewById(R.id.imageResultado); // antigamente precisava zasting no findViewById, mas agora nao precisa mais
            TextView textResult = findViewById(R.id.textResult);

            int numero = new Random().nextInt(3);

            String [] opcoes = { "pedra", "papel", "tesoura" };

            String escolhaApp = opcoes[ numero ];

            switch ( escolhaApp ) {

                case "pedra":

                    // define o imageView com determinada imagem, neste caso, pedra.png existente dentro de drawable. Pode ser video, texto, etc
                    imagemResultado.setImageResource(R.drawable.pedra);

                    break;

                case "papel":

                    imagemResultado.setImageResource((R.drawable.papel));

                    break;

                case "tesoura":

                    imagemResultado.setImageResource((R.drawable.tesoura));

                    break;

            }

            if ( // app ganhador
                    ( escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                    ( escolhaApp == "papel" && escolhaUsuario == "pedra" ) ||
                    ( escolhaApp == "tesoura" && escolhaUsuario == "papel")) {

                textResult.setText("Você perdeu :p");


            } else if ( // usuario ganhador
                    (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                    (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                    (escolhaUsuario == "tesoura" && escolhaApp == "papel")) {

                textResult.setText("Você venceu ;)");

            } else { // empate

                textResult.setText("Jogo empatado :)");

            }

            System.out.println(" Escolha do usuario: " + escolhaApp);

        }
    }
