package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import java.util.UUID

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(koala: Koala, onCrimeClicked: (crimeId: UUID) -> Unit) {
        binding.crimeTitle.text = koala.title
        binding.crimeDate.text = koala.date.toString()

        binding.root.setOnClickListener {
            onCrimeClicked(koala.id)
        }

        binding.crimeSolved.visibility = if (koala.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}
//ee
class CrimeListAdapter(
    private val koalas: List<Koala>,
    private val onCrimeClicked: (crimeId: UUID) -> Unit
) : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = koalas[position]
        holder.bind(crime, onCrimeClicked)
    }

    override fun getItemCount() = koalas.size
}
