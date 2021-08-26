import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstandroid.ItemsViewModel
import com.example.myfirstandroid.OpenTask
import com.example.myfirstandroid.R

class CustomAdapter(private val mList: List<ItemsViewModel>, val openTask: OpenTask) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        holder.textView.text = itemsViewModel.text
        holder.taskNum.text = "Task $position"
        holder.textView.setOnClickListener {
            openTask.taskOpener(itemsViewModel)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val taskNum: TextView = ItemView.findViewById(R.id.taskNum)
    }
}
