package com.example.travel.Comment_Package;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.travel.R;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "CommentExpandAdapter";
    private List<CommentDetial> commentDetialList;
    private List<ReplyDetail> replyDetailList;
    private Context context;
    private int pageIndex = 1;

    public CommentAdapter(Context context, List<CommentDetial> commentDetialList){
        this.context = context;
        this.commentDetialList = commentDetialList;
    }

    @Override
    public int getGroupCount() {
        return commentDetialList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        if(commentDetialList.get(i).getReplyDetailList() == null) {
            return 0;
        }
        else {
            return commentDetialList.get(i).getReplyDetailList().size() > 0 ? commentDetialList.get(i).getReplyDetailList().size() : 0;
        }
    }

    @Override
    public Object getGroup(int i) {
        return commentDetialList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return commentDetialList.get(i).getReplyDetailList().get(i1);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getCombinedChildId(groupPosition, childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    boolean isLike = false;

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpand, View convertView, ViewGroup viewGroup) {
        final GroupHolder groupHolder;

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_layout, viewGroup, false);
            groupHolder = new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }
        else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        Glide.with(context).load(R.drawable.user_other);
        groupHolder.tv_name.setText(commentDetialList.get(groupPosition).getNickName());
        groupHolder.tv_time.setText(commentDetialList.get(groupPosition).getCreateDate());
        groupHolder.tv_content.setText(commentDetialList.get(groupPosition).getContent());
        groupHolder.iv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLike) {
                    isLike = false;
                    groupHolder.iv_like.setColorFilter(Color.parseColor("#aaaaaa"));
                }
                else {
                    isLike = true;
                    groupHolder.iv_like.setColorFilter(Color.parseColor("#FF5C5C"));
                }
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        final ChildHolder childHolder;
        if(convertView == null) {
            convertView =  LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout, viewGroup, false);
            childHolder = new ChildHolder(convertView);
            convertView.setTag(childHolder);
        }
        else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        String replyUser = commentDetialList.get(groupPosition).getReplyDetailList().get(childPosition).getNickName();
        if(!TextUtils.isEmpty(replyUser)) {
            childHolder.tv_name.setText(replyUser + ":");
        }
        else {
            childHolder.tv_name.setText("无名"+":");
        }

        childHolder.tv_content.setText(commentDetialList.get(groupPosition).getReplyDetailList().get(childPosition).getContent());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private class GroupHolder {
        private ImageView logo;
        private TextView tv_name, tv_content, tv_time;
        private ImageView iv_like;
        public GroupHolder(View view) {
            logo = view.findViewById(R.id.comment_item_logo);
            tv_content = view.findViewById(R.id.comment_item_content);
            tv_name = view.findViewById(R.id.comment_item_userName);
            tv_time = view.findViewById(R.id.comment_item_userName);
            iv_like = view.findViewById(R.id.comment_item_like);
        }
    }

    private class ChildHolder {
        private TextView tv_name, tv_content;
        public ChildHolder(View view) {
            tv_name = view.findViewById(R.id.replay_item_user);
            tv_content = view.findViewById(R.id.replay_item_content);
        }
    }

    public void addTheCommentData(CommentDetial commentDetial) {
        if(commentDetial != null) {
            commentDetialList.add(commentDetial);
            notifyDataSetChanged();
        }
        else {
            throw new IllegalArgumentException("评论数据为空!");
        }
    }

    public void addTheReplyData(ReplyDetail replyDetail, int groupPosition) {
        if(replyDetail != null) {
            Log.e(TAG, "addTheReplyData: >>>>该刷新回复列表了:" + replyDetail.toString());
            if(commentDetialList.get(groupPosition).getReplyDetailList() != null) {
                commentDetialList.get(groupPosition).getReplyDetailList().add(replyDetail);
            }
            else {
                List<ReplyDetail> replyList = new ArrayList<>();
                replyList.add(replyDetail);
                commentDetialList.get(groupPosition).setReplylist(replyDetailList);
                addReplyList(replyList, groupPosition);
            }
            notifyDataSetChanged();
        }
        else {
            throw new IllegalArgumentException("回复数据为空!");
        }
    }

    private void addReplyList(List<ReplyDetail> replyDetailList, int groupPosition) {
        if(commentDetialList.get(groupPosition).getReplyDetailList() != null) {
            commentDetialList.get(groupPosition).getReplyDetailList().clear();
            commentDetialList.get(groupPosition).getReplyDetailList().addAll(replyDetailList);
        }
        else {
            commentDetialList.get(groupPosition).setReplylist(replyDetailList);
        }
        notifyDataSetChanged();
    }
}
