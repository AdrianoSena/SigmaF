package br.corp.sigma.sigmaf.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.model.Amostra;

public class AdapterListaImpactos extends BaseAdapter {

    private final List<Amostra> listaAmostras;
    private final Context context;

    public AdapterListaImpactos(List<Amostra> listaAmostras, Context context) {
        this.listaAmostras = listaAmostras;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaAmostras.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAmostras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaAmostras.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Amostra amostra = listaAmostras.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        //o android reutiliza as views que carregam na tela com o ConvertView
        if(convertView == null){
            view = inflater.inflate(R.layout.item_lista_impacto, parent, false);
        }
        //View também tem um findviewByID
        TextView campoImpacto =  view.findViewById(R.id.item_impacto_impacto);
        campoImpacto.setText(Integer.toString(amostra.getImpacto()));
        TextView campoProfundidade =  view.findViewById(R.id.item_impacto_profundidade);
        campoProfundidade.setText(Double.toString(amostra.getProfundidade()));
        return view;
    }
}
