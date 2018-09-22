package itc.ink.unit_android.unit_recyclerview.adapter.implement;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import itc.ink.unit_android.unit_recyclerview.adapter.MainWrapperAdapter;
import itc.ink.unit_android.unit_recyclerview.mode.mode_solution.SolutionDataMode;

/**
 * Created by yangwenjiang on 2018/9/14.
 */

public class SolutionDelegateImplement implements MainWrapperAdapter.DelegateInterface {
    private Context mContext;
    @Override
    public void handleTransaction(Context mContext, MainWrapperAdapter.WrapperVH mHolder, Object mData) {
        this.mContext=mContext;

        ArrayList<SolutionDataMode> solutionData=(ArrayList<SolutionDataMode>)mData;

        mHolder.solutionRecommendTopTextView.setOnClickListener(new SolutionRecommendTopTextViewClickListener());
        mHolder.solutionSortOneLayout.setOnClickListener(new SolutionSortOneLayoutClickListener());
        mHolder.solutionSortOneTitleTextView.setText(solutionData.get(0).getTitle());
        mHolder.solutionSortOneSummaryTextView.setText(solutionData.get(0).getSummary());
        Glide.with(mContext).load(solutionData.get(0).getImageurl_left()).into(mHolder.solutionSortOneLeftImageImageView);
        Glide.with(mContext).load(solutionData.get(0).getImageurl_right()).into(mHolder.solutionSortOneRightImageImageView);

        mHolder.solutionSortTwoLayout.setOnClickListener(new SolutionSortTwoLayoutClickListener());
        mHolder.solutionSortTwoTitleTextView.setText(solutionData.get(1).getTitle());
        mHolder.solutionSortTwoSummaryTextView.setText(solutionData.get(1).getSummary());
        Glide.with(mContext).load(solutionData.get(1).getImageurl_left()).into(mHolder.solutionSortTwoLeftImageImageView);
        Glide.with(mContext).load(solutionData.get(1).getImageurl_right()).into(mHolder.solutionSortTwoRightImageImageView);

        mHolder.solutionSortThreeLayout.setOnClickListener(new SolutionSortThreeLayoutClickListener());
        mHolder.solutionSortThreeTitleTextView.setText(solutionData.get(2).getTitle());
        mHolder.solutionSortThreeSummaryTextView.setText(solutionData.get(2).getSummary());
        Glide.with(mContext).load(solutionData.get(2).getImageurl_left()).into(mHolder.solutionSortThreeLeftImageImageView);
        Glide.with(mContext).load(solutionData.get(2).getImageurl_right()).into(mHolder.solutionSortThreeRightImageImageView);

        mHolder.solutionSortFourLayout.setOnClickListener(new SolutionSortFourLayoutClickListener());
        mHolder.solutionSortFourTitleTextView.setText(solutionData.get(3).getTitle());
        mHolder.solutionSortFourSummaryTextView.setText(solutionData.get(3).getSummary());
        Glide.with(mContext).load(solutionData.get(3).getImageurl_left()).into(mHolder.solutionSortFourLeftImageImageView);
        Glide.with(mContext).load(solutionData.get(3).getImageurl_right()).into(mHolder.solutionSortFourRightImageImageView);

        mHolder.solutionSubjectOneLayout.setOnClickListener(new SolutionSubjectOneLayoutClickListener());
        Glide.with(mContext).load(solutionData.get(4).getGifurl()).into(mHolder.solutionSubjectOneGifImageView);
        mHolder.solutionSubjectOneTitleTextView.setText(solutionData.get(4).getTitle());
        mHolder.solutionSubjectOneSummaryTextView.setText(solutionData.get(4).getSummary());

        mHolder.solutionOneLayout.setOnClickListener(new SolutionOneLayoutClickListener());
        Glide.with(mContext).load(solutionData.get(5).getImageurl()).into(mHolder.solutionOneImageImageView);
        mHolder.solutionOneTitleTextView.setText(solutionData.get(5).getTitle());
        mHolder.solutionOneSummaryTextView.setText(solutionData.get(5).getSummary());

        mHolder.solutionTwoLayout.setOnClickListener(new SolutionTwoLayoutClickListener());
        Glide.with(mContext).load(solutionData.get(6).getImageurl()).into(mHolder.solutionTwoImageImageView);
        mHolder.solutionTwoTitleTextView.setText(solutionData.get(6).getTitle());
        mHolder.solutionTwoSummaryTextView.setText(solutionData.get(6).getSummary());

        mHolder.solutionThreeLayout.setOnClickListener(new SolutionThreeLayoutClickListener());
        Glide.with(mContext).load(solutionData.get(7).getImageurl()).into(mHolder.solutionThreeImageImageView);
        mHolder.solutionThreeTitleTextView.setText(solutionData.get(7).getTitle());
        mHolder.solutionThreeSummaryTextView.setText(solutionData.get(7).getSummary());

        mHolder.solutionFourLayout.setOnClickListener(new SolutionFourLayoutClickListener());
        Glide.with(mContext).load(solutionData.get(8).getImageurl()).into(mHolder.solutionFourImageImageView);
        mHolder.solutionFourTitleTextView.setText(solutionData.get(8).getTitle());
        mHolder.solutionFourSummaryTextView.setText(solutionData.get(8).getSummary());

        mHolder.solutionSimpleOneLayout.setOnClickListener(new SolutionSimpleOneLayoutClickListener());
        mHolder.solutionSimpleOneTitleTextView.setText(solutionData.get(9).getTitle());
        mHolder.solutionSimpleOneSummaryTextView.setText(solutionData.get(9).getSummary());

        mHolder.solutionSimpleTwoLayout.setOnClickListener(new SolutionSimpleTwoLayoutClickListener());
        mHolder.solutionSimpleTwoTitleTextView.setText(solutionData.get(10).getTitle());
        mHolder.solutionSimpleTwoSummaryTextView.setText(solutionData.get(10).getSummary());

        mHolder.solutionSimpleThreeLayout.setOnClickListener(new SolutionSimpleThreeLayoutClickListener());
        mHolder.solutionSimpleThreeTitleTextView.setText(solutionData.get(11).getTitle());
        mHolder.solutionSimpleThreeSummaryTextView.setText(solutionData.get(11).getSummary());
    }

    class SolutionRecommendTopTextViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案推荐榜单被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别1被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别2被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortThreeLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别3被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSortFourLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案类别4被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSubjectOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"专题方案被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSubjectOneVideoVideoViewErrorListener implements MediaPlayer.OnErrorListener{
        private VideoView mVideoView;
        public SolutionSubjectOneVideoVideoViewErrorListener(VideoView mVideoView) {
            this.mVideoView=mVideoView;
        }

        @Override
        public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
            mVideoView.stopPlayback();
            Toast.makeText(mContext,"方案专题视频无法播放",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    class SolutionSubjectOneVideoVideoViewCompletionListener implements  MediaPlayer.OnCompletionListener{
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }

    class SolutionOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案1被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案2被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionThreeLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案3被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionFourLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案4被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSimpleOneLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案5被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSimpleTwoLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案6被点击",Toast.LENGTH_SHORT).show();
        }
    }

    class SolutionSimpleThreeLayoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"方案7被点击",Toast.LENGTH_SHORT).show();
        }
    }
}
