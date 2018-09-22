package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.mode_action.ActionSubjectDataMode;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class ActionSubjectDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;
    @Override
    public void handleTransaction(Context mContext, MainWrapperAdapter.WrapperVH mHolder, Object mData) {
        this.mContext=mContext;

        ArrayList<ActionSubjectDataMode> solutionData=(ArrayList<ActionSubjectDataMode>)mData;

        mHolder.actionRecommendTopTextView.setOnClickListener(new ActionRecommendTopTextViewClickListener());
        mHolder.actionSubjectOneLayout.setOnClickListener(new ActionSubjectOneLayoutClickListener());
        mHolder.actionSubjectOneTitleTextView.setText(solutionData.get(0).getTitle());
        mHolder.actionSubjectOneSummaryTextView.setText(solutionData.get(0).getSummary());
        Glide.with(mContext).load(solutionData.get(0).getGifurl()).into(mHolder.actionSubjectOneGifImageView);
    }

    class ActionRecommendTopTextViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"活动推荐榜单被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ActionSubjectOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"活动专题被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class ActionSubjectOneVideoVideoViewErrorListener implements MediaPlayer.OnErrorListener{
        private VideoView mVideoView;
        public ActionSubjectOneVideoVideoViewErrorListener(VideoView mVideoView) {
            this.mVideoView=mVideoView;
        }

        @Override
        public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
            mVideoView.stopPlayback();
            Toast.makeText(mContext,"活动专题视频无法播放",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    class ActionSubjectOneVideoVideoViewCompletionListener implements  MediaPlayer.OnCompletionListener{
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }
}
