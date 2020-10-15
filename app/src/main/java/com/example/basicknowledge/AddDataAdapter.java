package com.example.basicknowledge;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddDataAdapter extends RecyclerView.Adapter<AddDataAdapter.VH> {
    private List<String> addViewed;
    private final int Normal = 1;
    private final int FooterNum = 2;
    private View footerView;
    private View normalView;

    public AddDataAdapter(List<String> addViewed) {
        this.addViewed = addViewed;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == FooterNum) {
            footerView = View.inflate(viewGroup.getContext(), R.layout.activity_footer_view, null);
            return new VH(footerView);
        } else {
            normalView = View.inflate(viewGroup.getContext(), R.layout.activity_normal_view, null);
            return new VH(normalView);
        }
    }

    /** 绑定view  设置资源 和 各种事件
     *
     * @param vh
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int i) {
        if (addViewed.size() != i) {
            vh.tvClickAddTextButton.setText(addViewed.get(i));
            vh.tvClickAddTextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.setOnItemClickListener(v,addViewed.get(i));
                }
            });
            vh.tvClickAddTextButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListenerRemove.setLongClickListener(v);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return addViewed.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == addViewed.size()) {
            return FooterNum;
        } else {
            return Normal;
        }
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView tvClickAddTextButton;
        private TextView tvAddTextButton;

        public VH(@NonNull final View itemView) {
            super(itemView);
            if (itemView == normalView) {
                tvClickAddTextButton = (TextView) itemView.findViewById(R.id.tv_click_add_text);
            } else {
                tvAddTextButton = (TextView) itemView.findViewById(R.id.tv_add_text_button);
                tvAddTextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(itemView.getContext(), "点击了添加按钮", Toast.LENGTH_SHORT).show();
                        addDataListener.onAddDataListener(getLayoutPosition());
                    }
                });
            }
        }
    }

    /**
     * 声明回调接口
     */
    private OnItemClickListener onItemClickListener;

    /**
     * 绑定回调接口
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 对外提供回调接口
     */
    interface OnItemClickListener {
        void setOnItemClickListener(View view,String str);
    }

    longClickListenerRemove longClickListenerRemove;
    public void setLongClickListenerRemove(AddDataAdapter.longClickListenerRemove longClickListenerRemove) {
        this.longClickListenerRemove = longClickListenerRemove;
    }
    interface longClickListenerRemove {

        void setLongClickListener(View view);
    }

    addDataListener addDataListener;
    public void setAddDataListener(AddDataAdapter.addDataListener addDataListener) {
        this.addDataListener = addDataListener;
    }
    interface addDataListener {
        void onAddDataListener(int position);

    }



}
