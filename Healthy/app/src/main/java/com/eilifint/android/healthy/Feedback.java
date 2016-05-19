package com.eilifint.android.healthy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }

    /**
     * This method returns the name.
     */
    public String getName() {
        TextView nameTextView = (TextView) findViewById(R.id.name_text);
        String name = nameTextView.getText().toString();

        return name;
    }

    /**
     * This method returns the comment.
     */
    public String getComment() {
        TextView commentTextView = (TextView) findViewById(R.id.comment_text);
        String comment = commentTextView.getText().toString();

        return comment;
    }

    /**
     * This method returns rating value.
     */
    public float getRatingNumber() {
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_Bar);
        float value = ratingBar.getRating();

        return value;
    }

    /**
     * This method returns rating Comment.
     *
     * @param ratingNumber numerical value of rating
     */
    public String getRatingComment(float ratingNumber) {
        String ratingComment;

        if (ratingNumber > 4) {
            ratingComment = "Excellent";
        } else if (ratingNumber > 3 && ratingNumber <= 4) {
            ratingComment = "Good";
        } else if (ratingNumber > 2 && ratingNumber <= 3) {
            ratingComment = "Average";
        } else if (ratingNumber > 1 && ratingNumber <= 2) {
            ratingComment = "Below Average";
        } else
            ratingComment = "Poor";

        return ratingComment;
    }

    /**
     * This method returns feedback summary.
     */
    public String feedbackSummary() {
        String name, comment, summary, ratingComment;
        float rating;

        //invoking methods
        name = getName();
        comment = getComment();
        rating = getRatingNumber();
        ratingComment = getRatingComment(rating);

        //concatenating summary
        summary = "Healthy(Feedback) \n"
                + "Hi im " + name + ".\n"
                + "I'm rating your app as: "
                + ratingComment + "\n" + comment;

        return summary;
    }

    /**
     * This method is called when the SEND FEEDBACK button is clicked.
     */
    public void sendFeedback(View view) {

        String summaryMessage;
        String[] addresses = {"info@eilifint.com"};

        // Name must be provided to send feedback
        if (!getName().equals("")) {
            summaryMessage = feedbackSummary();

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, "5 ways to stay healthy");
            intent.putExtra(Intent.EXTRA_TEXT, summaryMessage);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        } else {
            // Toast to inform missing name
            Toast.makeText(this, "Please type your name", Toast.LENGTH_SHORT).show();
        }
    }


}
