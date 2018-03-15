/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.vgarcama.cleanarchitecturepractice.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vgarcama.cleanarchitecturepractice.R;
import com.example.vgarcama.cleanarchitecturepractice.view.model.PostsModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Adaptar that manages a collection of {@link PostsModel}.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

  public interface OnItemClickListener {
    void onUserItemClicked(PostsModel userModel);
  }

  private List<PostsModel> usersCollection;
  private final LayoutInflater layoutInflater;

  private OnItemClickListener onItemClickListener;

  @Inject
  PostsAdapter(Context context) {
    this.layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.usersCollection = Collections.emptyList();
  }

  @Override
  public int getItemCount() {
    return (this.usersCollection != null) ? this.usersCollection.size() : 0;
  }

  @Override
  public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //final View view = this.layoutInflater.inflate(R.layout.row_user, parent, false);
    return new PostsViewHolder(null);
  }

  @Override
  public void onBindViewHolder(PostsViewHolder holder, final int position) {
    final PostsModel postsModel = this.usersCollection.get(position);
    holder.textViewTitle.setText(postsModel.getTitle());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (PostsAdapter.this.onItemClickListener != null) {
          PostsAdapter.this.onItemClickListener.onUserItemClicked(postsModel);
        }
      }
    });
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  public void setUsersCollection(Collection<PostsModel> usersCollection) {
    this.validateUsersCollection(usersCollection);
    this.usersCollection = (List<PostsModel>) usersCollection;
    this.notifyDataSetChanged();
  }

  public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  private void validateUsersCollection(Collection<PostsModel> usersCollection) {
    if (usersCollection == null) {
      throw new IllegalArgumentException("The list cannot be null");
    }
  }

  static class PostsViewHolder extends RecyclerView.ViewHolder {
    // TODO: REVISAR EL IMPORT @Bind(R.id.title)
    TextView textViewTitle;

    PostsViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
