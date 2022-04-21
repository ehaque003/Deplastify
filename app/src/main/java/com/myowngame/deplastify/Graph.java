package com.myowngame.deplastify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1, Log.data.get(Log.data.size()-1)),
                new DataPoint(2, Log.data.get(Log.data.size()-2)),
                new DataPoint(3, Log.data.get(Log.data.size()-3)),
                new DataPoint(4, Log.data.get(Log.data.size()-4)),
                new DataPoint(5, Log.data.get(Log.data.size()-5)),
                new DataPoint(6, Log.data.get(Log.data.size()-6)),
                new DataPoint(7, Log.data.get(Log.data.size()-7)),
                new DataPoint(8, Log.data.get(Log.data.size()-8)),
                new DataPoint(9, Log.data.get(Log.data.size()-9)),
                new DataPoint(10, Log.data.get(Log.data.size()-10))
        });

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
