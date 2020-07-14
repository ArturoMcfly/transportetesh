package com.greemcfly.mexitransit;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class rutasMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas_mapa);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //ruta1
        LatLng miUbicacion = new LatLng(19.4552651, -99.2445359);
        mMap.addMarker(new MarkerOptions().position(miUbicacion).title("Mi ubicacion").snippet("Hola ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        // Add a marker in Sydney and move the camera
        LatLng ruta1Basetesh = new LatLng(19.4087164, -99.319087);
        mMap.addMarker(new MarkerOptions().position(ruta1Basetesh).title("TESH Huixquilucan").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.fromResource(R.drawable.teshr)));

        LatLng  ruta1BaseToreo= new LatLng(19.4604001, -99.2170568);
        mMap.addMarker(new MarkerOptions().position(ruta1BaseToreo).title("Mexi Puerto Cuatro caminos").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.fromResource(R.drawable.teshr)));

        LatLng ruta1ParadaPrice = new LatLng(19.4663492, -99.2354453);
        mMap.addMarker(new MarkerOptions().position(ruta1ParadaPrice).title("Parada Price Shoes").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));//cambiamos el color del icono

        LatLng ruta1ParadaLomalinda = new LatLng(19.460265, -99252563);
        mMap.addMarker(new MarkerOptions().position(ruta1ParadaLomalinda).title("Parada Lomalinda").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng ruta1ParadaLosCuartos = new LatLng(19.448672, -99.2851898);
        mMap.addMarker(new MarkerOptions().position(ruta1ParadaLosCuartos).title("Parada Los Cuartos").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng ruta1ParadaCampamento = new LatLng(19.451234, -99.2724454);
        mMap.addMarker(new MarkerOptions().position(ruta1ParadaCampamento).title("Parada El Capulin").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng ruta1ParadaElCastillo = new LatLng(19.436309, -99.304035);
        mMap.addMarker(new MarkerOptions().position(ruta1ParadaElCastillo).title("Parada El Castillo").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng ruta1ParadaLaCebada = new LatLng(19.4354009, -99.3341175);
        mMap.addMarker(new MarkerOptions().position(ruta1ParadaLaCebada).title("Parada La Cebada").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng ruta1ParadaUMB = new LatLng(19.4095885, -99.3198525);
        mMap.addMarker(new MarkerOptions().position(ruta1ParadaUMB).title("Parada UMB").snippet("Ruta Tesh transporte seguro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        //Ruta2
        LatLng ruta2BaseLaTolva = new LatLng(19.4557657, -99.2501686);
        mMap.addMarker(new MarkerOptions().position(ruta2BaseLaTolva).title("Mercado de la tolva").snippet("Ruta 18 Zome-Cine premier").icon(BitmapDescriptorFactory.fromResource(R.drawable.rutadie)));

        LatLng  ruta2BasePeriferico= new LatLng(19.478304, -99.231863);
        mMap.addMarker(new MarkerOptions().position(ruta2BasePeriferico).title("Cine premier").snippet("Ruta 18 Zome-Cine premier").icon(BitmapDescriptorFactory.fromResource(R.drawable.rutadie)));
        LatLng ruta2ParadaVicente = new LatLng(19.456423, -99.243023);
        mMap.addMarker(new MarkerOptions().position(ruta2ParadaVicente).title("Parada Vicente Guerrero").snippet("Ruta 18 Zome-Cine premier").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng ruta2PrimeroDeMayo = new LatLng(19.4640134, -99.2401353);
        mMap.addMarker(new MarkerOptions().position(ruta2PrimeroDeMayo).title("Parada Puente de la 1ro de mayo").snippet("Ruta 18 Zome-Cine premier").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng ruta2ElMolinito = new LatLng(19.458370, -99.237940);
        mMap.addMarker(new MarkerOptions().position(ruta2ElMolinito).title("El molinito").snippet("Ruta 18 Zome-Cine premier").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));


        //Ruta UESH country



        //LatLng cancun = new LatLng(21.1617854, -86.8510468);
        //mMap.addMarker(new MarkerOptions().position(cancun).title("Marker in Cancun").snippet("Aqui va la descripcion").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));//cambiamos el color del icono

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miUbicacion, 11));
    }
}
