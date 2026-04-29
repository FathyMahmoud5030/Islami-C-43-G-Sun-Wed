package com.route.islamic43gsunwed.fragments.quran.adapter

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic43gsunwed.R
import com.route.islamic43gsunwed.databinding.ItemRadioBinding
import com.route.islamic43gsunwed.fragments.quran.model.RadiosItem

class RadioAdapter(var items: List<RadiosItem?>? = null) :
    RecyclerView.Adapter<RadioAdapter.ViewHolder>() {

    companion object {
        private var mediaPlayer: MediaPlayer? = null
        private var currentPlayingUrl: String? = null
    }

    class ViewHolder(val binding: ItemRadioBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRadioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.binding.radioName.text = item?.name

        if (currentPlayingUrl == item?.url && mediaPlayer?.isPlaying == true) {
            holder.binding.playPauseBtn.setImageResource(R.drawable.ic_pause) // لازم يكون عندك أيقونة Pause
        } else {
            holder.binding.playPauseBtn.setImageResource(R.drawable.ic_play)
        }

        holder.binding.playPauseBtn.setOnClickListener {
            handlePlayPause(item?.url)
            notifyDataSetChanged()
        }
    }

    private fun handlePlayPause(url: String?) {
        if (url == null) return

        if (currentPlayingUrl == url && mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        } else if (currentPlayingUrl == url && mediaPlayer != null) {
            mediaPlayer?.start()
        } else {
            stopAndPlayNew(url)
        }
    }

    private fun stopAndPlayNew(url: String) {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null

        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepareAsync()
            setOnPreparedListener {
                start()
                currentPlayingUrl = url
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    fun bindData(newItems: List<RadiosItem?>?) {
        items = newItems
        notifyDataSetChanged()
    }
}