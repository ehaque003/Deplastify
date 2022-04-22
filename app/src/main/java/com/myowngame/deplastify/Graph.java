package com.myowngame.deplastify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.nio.channels.GatheringByteChannel;

public class Graph extends AppCompatActivity {

    // creating a variable
    // for our graph view.
    //GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        // on below line we are initializing our graph view.
        GraphView graphView = findViewById(R.id.idGraphView);
        Button backToLog = findViewById(R.id.backLog);
        // on below line we are adding data to our graph view.
        int size = Log.data.size();
        LineGraphSeries<DataPoint> series = null;
        if(size<=5){
            Toast.makeText(getApplicationContext(), "Need At Least 5 Reading Until Graph Is Ready", Toast.LENGTH_LONG);
        }
        else if(size <= 10){
            series = new LineGraphSeries<DataPoint>(new DataPoint[]{

                    new DataPoint(1, Log.data.get(4)),
                    new DataPoint(2, Log.data.get(3)),
                    new DataPoint(3, Log.data.get(2)),
                    new DataPoint(4, Log.data.get(1)),
                    new DataPoint(5, Log.data.get(0))
            });
        }

        else if(size <= 20){
            series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(1, Log.data.get(8)),
                    new DataPoint(2, Log.data.get(7)),
                    new DataPoint(3, Log.data.get(6)),
                    new DataPoint(4, Log.data.get(5)),
                    new DataPoint(5, Log.data.get(4)),
                    new DataPoint(6, Log.data.get(3)),
                    new DataPoint(7, Log.data.get(2)),
                    new DataPoint(8, Log.data.get(1)),
                    new DataPoint(9, Log.data.get(0))
            });
        }

        else{
            series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(1, Log.data.get(19)),
                    new DataPoint(2, Log.data.get(18)),
                    new DataPoint(3, Log.data.get(17)),
                    new DataPoint(4, Log.data.get(16)),
                    new DataPoint(5, Log.data.get(15)),
                    new DataPoint(6, Log.data.get(14)),
                    new DataPoint(7, Log.data.get(13)),
                    new DataPoint(8, Log.data.get(12)),
                    new DataPoint(9, Log.data.get(11)),
                    new DataPoint(10, Log.data.get(10)),
                    new DataPoint(11, Log.data.get(9)),
                    new DataPoint(12, Log.data.get(8)),
                    new DataPoint(13, Log.data.get(7)),
                    new DataPoint(14, Log.data.get(6)),
                    new DataPoint(15, Log.data.get(5)),
                    new DataPoint(16, Log.data.get(4)),
                    new DataPoint(17, Log.data.get(3)),
                    new DataPoint(18, Log.data.get(2)),
                    new DataPoint(19, Log.data.get(1)),
                    new DataPoint(20, Log.data.get(0))
            });
        }

        graphView.addSeries(series);

        backToLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Graph.this, Log.class);
                startActivity(intent);

            }
        });
    }
}
