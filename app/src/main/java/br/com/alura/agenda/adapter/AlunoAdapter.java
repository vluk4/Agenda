package br.com.alura.agenda.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.modelo.Aluno;

/**
 * Created by Victor on 05/07/2018.
 */

public class AlunoAdapter extends BaseAdapter {
    private final List<Aluno> alunos;
    private final Context context;

    public AlunoAdapter(Context context, List<Aluno> alunos) {
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Aluno aluno = alunos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = view.findViewById(R.id.item_nome);
        campoNome.setText(aluno.getNome());

        TextView campoEndereco = view.findViewById(R.id.item_endereco);
        if(campoEndereco != null){
            campoEndereco.setText(aluno.getEndereco());
        }
        TextView campoGitHub = view.findViewById(R.id.item_github);
        if (campoGitHub != null){
            campoGitHub.setText(aluno.getGitHub());
        }

        TextView campoTelefone = view.findViewById(R.id.item_numero);
        campoTelefone.setText(aluno.getTelefone());

        ImageView campoFoto = view.findViewById(R.id.item_foto);
        String caminhoFoto = aluno.getCaminhoFoto();
        if (caminhoFoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            campoFoto.setImageBitmap(bitmapReduzido);
        }

        return view;
    }
}
