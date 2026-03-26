package com.ankangban.health.features.consultation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ankangban.health.R
import com.ankangban.health.ui.viewmodel.ConsultationViewModel

class ChatAdapter : ListAdapter<ConsultationViewModel.UiMessage, ChatAdapter.MessageViewHolder>(MessageDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).isUser) R.layout.item_message_right else R.layout.item_message_left
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvContent: TextView = itemView.findViewById(R.id.tvContent)
        private val ivAvatar: ImageView? = itemView.findViewById(R.id.ivAvatar)
        private val tvSender: TextView? = itemView.findViewById(R.id.tvSender)
        private val ivImage: ImageView? = itemView.findViewById(R.id.ivImage)

        fun bind(message: ConsultationViewModel.UiMessage) {
            tvContent.text = message.content
            
            // Handle Image Message
            if (message.type == ConsultationViewModel.MessageType.IMAGE && message.attachmentUri != null) {
                ivImage?.visibility = View.VISIBLE
                tvContent.visibility = if (message.content.isEmpty()) View.GONE else View.VISIBLE
                try {
                    ivImage?.setImageURI(android.net.Uri.parse(message.attachmentUri))
                } catch (e: Exception) {
                    ivImage?.setImageResource(R.drawable.ic_launcher_foreground) // Error placeholder
                }
            } else {
                ivImage?.visibility = View.GONE
                tvContent.visibility = View.VISIBLE
            }
            
            // Set Avatar/Name based on sender
            if (!message.isUser) {
                tvSender?.text = message.senderName
                if (message.senderName.contains("康博士")) {
                    ivAvatar?.setImageResource(R.drawable.ic_robot)
                    ivAvatar?.setColorFilter(0xFF2196F3.toInt()) // Blue
                } else {
                    ivAvatar?.setImageResource(R.drawable.ic_doctor_male)
                    ivAvatar?.setColorFilter(0xFF1976D2.toInt()) // Dark Blue
                }
            } else {
                // User Avatar
                 ivAvatar?.setImageResource(R.drawable.ic_user_placeholder)
            }
        }
    }

    class MessageDiffCallback : DiffUtil.ItemCallback<ConsultationViewModel.UiMessage>() {
        override fun areItemsTheSame(oldItem: ConsultationViewModel.UiMessage, newItem: ConsultationViewModel.UiMessage): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: ConsultationViewModel.UiMessage, newItem: ConsultationViewModel.UiMessage): Boolean {
            return oldItem == newItem
        }
    }
}
