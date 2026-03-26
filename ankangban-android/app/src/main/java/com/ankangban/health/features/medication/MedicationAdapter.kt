package com.ankangban.health.features.medication

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ankangban.health.core.storage.dao.MedicationDao
import com.ankangban.health.databinding.ItemMedicationBinding

class MedicationAdapter(
    private val onEditClick: (MedicationDao.MedicationWithReminders) -> Unit
) : ListAdapter<MedicationDao.MedicationWithReminders, MedicationAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMedicationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemMedicationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MedicationDao.MedicationWithReminders) {
            val med = item.medication
            binding.tvName.text = med.name
            binding.tvDosage.text = "每次 ${med.dosage} | ${med.frequency}"
            binding.chipStock.text = "剩 ${med.totalStock} ${med.unit}"
            
            if (med.imageUri != null) {
                try {
                    binding.ivMedication.setImageURI(Uri.parse(med.imageUri))
                } catch (e: Exception) {
                    // Fallback handled by placeholder
                }
            }
            
            val activeReminders = item.reminders.filter { it.isEnabled }.sortedBy { it.hour * 60 + it.minute }
            if (activeReminders.isNotEmpty()) {
                val next = activeReminders.firstOrNull { 
                    // Simple logic: just show the first one for now, or the next one based on current time
                    // For UI display simplicity: show the first configured reminder
                    true 
                }
                if (next != null) {
                    binding.tvNextReminder.text = String.format("下一次提醒：%02d:%02d (%s)", next.hour, next.minute, next.label ?: "服药")
                    binding.tvNextReminder.visibility = View.VISIBLE
                }
            } else {
                binding.tvNextReminder.visibility = View.GONE
            }

            binding.root.setOnClickListener { onEditClick(item) }
            binding.btnEdit.setOnClickListener { onEditClick(item) }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<MedicationDao.MedicationWithReminders>() {
        override fun areItemsTheSame(oldItem: MedicationDao.MedicationWithReminders, newItem: MedicationDao.MedicationWithReminders): Boolean {
            return oldItem.medication.id == newItem.medication.id
        }

        override fun areContentsTheSame(oldItem: MedicationDao.MedicationWithReminders, newItem: MedicationDao.MedicationWithReminders): Boolean {
            return oldItem == newItem
        }
    }
}
