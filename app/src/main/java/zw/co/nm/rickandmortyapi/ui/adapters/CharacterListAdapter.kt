package zw.co.nm.rickandmortyapi.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import zw.co.nm.rickandmortyapi.databinding.ItemCharacterBinding
import zw.co.nm.rickandmortyapi.models.CharacterModel
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.ui.MainActivity

class CharacterListAdapter(
    private val dataSet: List<GetAllCharactersResponse.Result>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onItemClick: ((CharacterModel) -> Unit)? = null
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
         val data = dataSet[position]
         Picasso.get().load(dataSet[position].image).into(itemCharacterBinding!!.imageView)
         holder.itemView.setOnClickListener {
             Toast.makeText(holder.itemView.context, data.id.toString(), Toast.LENGTH_SHORT).show()
         }


    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ItemViewHolder(itemCharacterBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(itemCharacterBinding.root) {

    }
}

