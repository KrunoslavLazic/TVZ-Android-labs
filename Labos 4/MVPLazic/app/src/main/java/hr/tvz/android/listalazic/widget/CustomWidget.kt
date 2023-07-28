package hr.tvz.android.listalazic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.widget.RemoteViews
import com.squareup.picasso.Picasso
import hr.tvz.android.listalazic.ListFragment
import hr.tvz.android.listalazic.R

class CustomWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val gitem = ListFragment.gitemList[ListFragment.gitemList.size - 1]

        val remoteViews = RemoteViews(context.packageName, R.layout.widget)
        remoteViews.setTextViewText(R.id.widgetNameTextView, gitem.name)

        if (gitem.image == 1001) {
            Picasso.get().load("https://img.freepik.com/free-vector/bananas-cartoon-sticker-white-background_1308-87419.jpg?w=1060&t=st=1687258634~exp=1687259234~hmac=733828edb820bb2943888e64020868bb1ce5393c42152843dde4d23ebc4a5e41")
                .into(remoteViews, R.id.widgetImageView, appWidgetIds)
        } else if (gitem.image == 1002) {
            Picasso.get().load("https://img.freepik.com/free-vector/realistic-milk-boxes-isolated_1284-35984.jpg?w=826&t=st=1687259050~exp=1687259650~hmac=7b08e0fb5d1b6e3d7d8d283928dc1872f20f967fd7dab2341117eb6e26bcf05c")
                .into(remoteViews, R.id.widgetImageView, appWidgetIds)
        } else if (gitem.image==1003) {
            Picasso.get().load("https://img.freepik.com/premium-photo/broccoli-is-being-tossed-air-word-broccoli-is-bottom_721662-915.jpg")
                .into(remoteViews, R.id.widgetImageView, appWidgetIds)
        }
        else if (gitem.image==1004) {
        Picasso.get().load("https://img.freepik.com/free-vector/cheese-plate_1308-118321.jpg?w=1380&t=st=1687259162~exp=1687259762~hmac=975203356404d87d10df1bb610c7f45812dafc60d1f078a19aafdc51996e095a")
            .into(remoteViews, R.id.widgetImageView, appWidgetIds)
        }
        else{
            Picasso.get().load("                https://img.freepik.com/free-photo/top-view-fresh-chicken-eggs_23-2148592154.jpg?w=1380&t=st=1687259199~exp=1687259799~hmac=e70e27b0102429aa9ed2ea66421eae6e451c6fe421e7d9cfd473291f4b996eef\n")
                .into(remoteViews, R.id.widgetImageView, appWidgetIds)
        }


        val componentName = ComponentName(context, CustomWidget::class.java)
        appWidgetManager.updateAppWidget(componentName, remoteViews)
    }
}