package cz.uhk.fim.brahavl1.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import cz.uhk.fim.brahavl1.recyclerview.R;
import cz.uhk.fim.brahavl1.recyclerview.model.Person;
import cz.uhk.fim.brahavl1.recyclerview.model.PersonsData;

/**
 * Created by brahavl1 on 19.03.2018.
 */


//celej seynam je reczcler view a view holder spravuje jeden radek
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {

    private PersonsData personsData;

    private OnItemDeleteClickListener onItemDeleteClickListener;


    public void setOnItemDeleteClickListener(OnItemDeleteClickListener listener){
        this.onItemDeleteClickListener = listener;

    }

    public RecyclerViewAdapter(PersonsData personsData) {
        this.personsData = personsData;
    }

    @Override //vytvori holdery polde poctu co se vejde vola se jenom pri inicializaci
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //taha xml

        View view = layoutInflater.inflate(R.layout.item_person, null); //jeden radek bude vypadat jako item person xml



        PersonViewHolder viewHolder = new PersonViewHolder(view);
        return viewHolder;
    }

    //SPravnce jednoho radkiu
    @Override//cejzhe ba hajy hsen oitucu a hajynz gikderz ti bzdz davat
    public void onBindViewHolder(PersonViewHolder holder, int position) {//pozice a data v holderu - do holderu se
        Person person = personsData.get(position);
        holder.setPerson(person); //do hodleru se hodi data co se maj dat pro dany radek
    }

    @Override
    public int getItemCount() {
        return personsData.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private View viewGender;
        private SeekBar seekBarAge;

        private Button buttonChange;


        public PersonViewHolder(View itemView) {
            super(itemView);


            //tady to budeme sypat do view, takže si nejdříve vytáhneme prvky z xml - dostavame instance danych veci z xml
            textViewName= itemView.findViewById(R.id.textViewName);
            viewGender = itemView.findViewById(R.id.viewGender);
            seekBarAge = itemView.findViewById(R.id.seekBar);
            buttonChange = itemView.findViewById(R.id.btnChange);


        }

        public void setPerson (final Person person){

            textViewName.setText(person.getName());
            if (person.isMale()){
                viewGender.setBackgroundResource(R.color.colorMale);
            }else {
                viewGender.setBackgroundResource(R.color.colorFemale);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //onItemDeleteClickListener.onItemDelete(getAdapterPosition()); //tohle by smazalo celej řádek, když by se na to kliklo
                }
            });


            seekBarAge.setProgress(person.getAge());
            buttonChange.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onItemDeleteClickListener.onItemDelete(getAdapterPosition()); //tohle maže při stisknutí tlačítka řádek
                }
            });
        }
    }
}
