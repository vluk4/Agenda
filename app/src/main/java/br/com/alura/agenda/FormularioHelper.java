package br.com.alura.agenda;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import br.com.alura.agenda.modelo.Aluno;

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoEmail;
    private final EditText campoGitHub;
    private final ImageView campoFoto;
    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity){

        this.aluno = new Aluno();
        campoNome = activity.findViewById(R.id.formulario_nome);
        campoEndereco = activity.findViewById(R.id.formulario_endereco);
        campoTelefone = activity.findViewById(R.id.formulario_telefone);
        campoEmail = activity.findViewById(R.id.formulario_email);
        campoGitHub = activity.findViewById(R.id.formulario_github);
        campoFoto = activity.findViewById(R.id.formulario_foto);
    }

    public Aluno getAluno() {

        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setEmail(campoEmail.getText().toString());
        aluno.setGitHub(campoGitHub.getText().toString());
        aluno.setCaminhoFoto((String) campoFoto.getTag());

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        this.aluno = aluno;
        this.campoNome.setText(aluno.getNome());
        this.campoEndereco.setText(aluno.getEndereco());
        this.campoTelefone.setText(aluno.getTelefone());
        this.campoEmail.setText(aluno.getEmail());
        this.campoGitHub.setText(aluno.getGitHub());
        carregaImagem(aluno.getCaminhoFoto());
    }

    public void carregaImagem(String caminhoFoto) {
        Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
        bitmap = Bitmap.createScaledBitmap(bitmap, 720, 1080, true);
        campoFoto.setImageBitmap(bitmap);
        campoFoto.setTag(caminhoFoto);
    }
}
