
package sk.amir.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cocoapods.MapLibre.MLNMapView
import cocoapods.MapLibre.MLNOrnamentVisibility
import cocoapods.MapLibre.allowsTilting

@Composable
internal fun LoadUiSettings(
    uiSettings: MapUiSettings,
    currentMap: MLNMapView?,
) {
    LaunchedEffect(uiSettings.isCompassEnabled, currentMap) {
        currentMap?.compassView?.compassVisibility = if (uiSettings.isCompassEnabled) {
            MLNOrnamentVisibility.MLNOrnamentVisibilityAdaptive
        } else {
            MLNOrnamentVisibility.MLNOrnamentVisibilityHidden
        }
    }
    LaunchedEffect(uiSettings.isRotateGesturesEnabled, currentMap) {
        currentMap?.rotateEnabled = uiSettings.isRotateGesturesEnabled
    }
    LaunchedEffect(uiSettings.isTiltGesturesEnabled, currentMap) {
        currentMap?.allowsTilting = uiSettings.isTiltGesturesEnabled
    }
    LaunchedEffect(uiSettings.isZoomGesturesEnabled, currentMap) {
        currentMap?.zoomEnabled = uiSettings.isZoomGesturesEnabled
    }
    LaunchedEffect(uiSettings.isScrollGesturesEnabled, currentMap) {
        currentMap?.scrollEnabled = uiSettings.isScrollGesturesEnabled
    }
    LaunchedEffect(uiSettings.isLogoEnabled, currentMap) {
        currentMap?.logoView?.hidden = !uiSettings.isLogoEnabled
    }
    LaunchedEffect(uiSettings.isAttributionEnabled, currentMap) {
        currentMap?.attributionButton?.hidden = !uiSettings.isAttributionEnabled
    }
}
