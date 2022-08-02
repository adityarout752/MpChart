package com.example.charting
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
import com.github.mikephil.charting.utils.ColorTemplate


class MainActivity : AppCompatActivity() {
    private var chart: ScatterChart? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chart = findViewById(R.id.chart1);
        setDataChart()
    }

    @SuppressLint("ResourceAsColor")
    private fun setDataChart() {
        chart?.description?.isEnabled = true
        chart?.setBackgroundColor(Color.WHITE)
        chart?.setDrawGridBackground(false)
        chart?.setTouchEnabled(false);
       chart?.maxHighlightDistance = 50f;
        chart?.isDragEnabled = false;
        chart?.setScaleEnabled(true);
//        chart?.setDrawBorders(true)
//        chart?.setBorderColor(R.color.purple_200)



//        chart?.setMaxVisibleValueCount(200);
//        chart?.setPinchZoom(true);
        val l = chart!!.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.direction = Legend.LegendDirection.LEFT_TO_RIGHT
        l?.form = Legend.LegendForm.CIRCLE
        l?.maxSizePercent = 10f
        l?.isWordWrapEnabled = true

        l.setDrawInside(false)
        l.xOffset = 5f

        //y -axis
        val yl = chart!!.axisLeft
//        val yR = chart!!.axisRight
//        yR?.isEnabled = false
        yl!!.axisMaximum = 240f
        yl.axisMinimum = 50f
        yl.granularity =30f
        val upperLimitLine = LimitLine(180f)
        upperLimitLine.lineColor = R.color.purple_200
        yl.addLimitLine(upperLimitLine)

        val lowerLimitLine = LimitLine(90f)
        lowerLimitLine.lineColor =  R.color.purple_200
        yl.addLimitLine(lowerLimitLine)




        chart!!.axisRight.isEnabled = false

        val xl = chart!!.xAxis
        xl.position = XAxis.XAxisPosition.BOTTOM


        val xAxisLevel = listOf("1", "2", "3", "4", "5", "6", "7","8","9")
       xl.valueFormatter = IndexAxisValueFormatter(xAxisLevel)
        xl.setDrawGridLines(false)
        xl.granularity = 2f

        val values1: ArrayList<Entry> = ArrayList()

        values1.add(Entry(6F,120f))
        values1.add(Entry(7f,150f))
        values1.add(Entry(3f,130f))
        values1.add(Entry(9f,180f))
        values1.add(Entry(5f,90f))
        values1.add(Entry())

//       val rangeHigh=180
//        val rangeLow = 90
//        // zone draw
//        val increment: Int = (rangeHigh - rangeLow) / 20
//        var metricLine: Int = rangeLow
//
//        for (i in 0..22) {
//            val llRange = LimitLine(metricLine.toFloat(), "")
//            llRange.lineColor = Color.parseColor("#f8f8f8")
//            llRange.lineWidth = 10f
//            yl.addLimitLine(llRange)
//            metricLine += increment
//        }


        val desciption = Description()
        desciption.text = "Blood Glucose"
        desciption.textSize = 10f
        desciption.textColor = R.color.teal_200
//      desciption.setPosition()
        chart!!.description = desciption
        val set1 = ScatterDataSet(values1, "Blood Glucose")

        set1.setScatterShape(ScatterChart.ScatterShape.CIRCLE)

        set1.color = ColorTemplate.COLORFUL_COLORS[0]

        set1.scatterShapeSize = 25f

        val dataSets: ArrayList<IScatterDataSet> = ArrayList()


        dataSets.add(set1)

        val data = ScatterData(dataSets)

        chart!!.data = data

        chart!!.invalidate()
    }
}