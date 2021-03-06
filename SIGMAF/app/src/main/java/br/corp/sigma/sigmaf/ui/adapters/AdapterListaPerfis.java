package br.corp.sigma.sigmaf.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.model.PerfilSolo;

public class AdapterListaPerfis extends BaseAdapter {

    private final List<PerfilSolo> listaPerfis;
    private final Context context;

    public AdapterListaPerfis(Context context, List<PerfilSolo> listaPerfis) {
        this.listaPerfis = listaPerfis;
        this.context = context;
    }

    @Override
    public int getCount() {
       return listaPerfis.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPerfis.get(position);
    }

    //erá referente ao item clicado e que será devolvido
    @Override
    public long getItemId(int position) {
        return listaPerfis.get(position).getId();
    }

//    Método mais importante do adapter, ele é invocado quando alista precisa mostrar uma view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PerfilSolo perfil = listaPerfis.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        //o android reutiliza as views que carregam na tela com o ConvertView
        if(convertView == null){
            view = inflater.inflate(R.layout.item_lista_perfis, parent, false);
        }
        //View também tem um findviewByID
        TextView campoNome =  view.findViewById(R.id.item_impacto_impacto);
        campoNome.setText(perfil.getNome());
        TextView campoDescricao =  view.findViewById(R.id.item_impacto_profundidade);
        campoDescricao.setText(perfil.getDescricao());
        return view;
    }
}
