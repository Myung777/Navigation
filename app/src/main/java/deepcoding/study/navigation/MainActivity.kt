package deepcoding.study.navigation

import android.os.Bundle
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.PathOverlay

class MainActivity : AppCompatActivity() , OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map_fragment) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map_fragment, it).commit()
            }

        mapFragment.getMapAsync(this)


    }
    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        // ...
        val path = PathOverlay()
        path.coords = listOf(
            LatLng(37.57152, 126.97714),
            LatLng(37.56607, 126.98268),
            LatLng(37.56445, 126.97707),
            LatLng(37.55855, 126.97822)
        )
        path.map =naverMap
    }
}
