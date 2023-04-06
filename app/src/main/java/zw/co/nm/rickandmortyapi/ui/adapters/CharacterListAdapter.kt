package zw.co.nm.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import zw.co.nm.rickandmortyapi.databinding.ItemCharacterBinding
import zw.co.nm.rickandmortyapi.models.CharacterModel

class CharacterListAdapter(private val dataSet: ArrayList<CharacterModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemCharacterBinding: ItemCharacterBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        itemCharacterBinding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemCharacterBinding!!)
    }


    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Picasso.get().load(dataSet[position].image).into(itemCharacterBinding!!.imageView)
    }

    inner class ItemViewHolder(
        itemCharacterBinding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(itemCharacterBinding!!.root) {
    }
}

