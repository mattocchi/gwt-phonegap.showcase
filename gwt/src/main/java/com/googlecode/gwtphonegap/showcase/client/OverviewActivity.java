package com.googlecode.gwtphonegap.showcase.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.showcase.client.OverviewDisplay.Presenter;
import com.googlecode.gwtphonegap.showcase.client.about.AboutActivity;
import com.googlecode.gwtphonegap.showcase.client.accelerometer.AccelerometerActivity;
import com.googlecode.gwtphonegap.showcase.client.camera.CameraActivity;
import com.googlecode.gwtphonegap.showcase.client.compass.CompassActivity;
import com.googlecode.gwtphonegap.showcase.client.connection.ConnectionActivity;
import com.googlecode.gwtphonegap.showcase.client.contact.ContactActivity;
import com.googlecode.gwtphonegap.showcase.client.device.DeviceActivity;
import com.googlecode.gwtphonegap.showcase.client.event.EventActivity;
import com.googlecode.gwtphonegap.showcase.client.file.FileActivity;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationActivity;
import com.googlecode.gwtphonegap.showcase.client.inappbrowser.InAppBrowserActivity;
import com.googlecode.gwtphonegap.showcase.client.media.MediaActivity;
import com.googlecode.gwtphonegap.showcase.client.model.PGModule;
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationActivity;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class OverviewActivity extends MGWTAbstractActivity implements Presenter {

  private final ClientFactory clientFactory;
  private List<PGModule> currentList;

  public OverviewActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    OverviewDisplay display = clientFactory.getOverviewDisplay();

    currentList = getModuleList();

    display.display(currentList);

    display.setPresenter(this);

    panel.setWidget(display);
  }

  private List<PGModule> getModuleList() {
    ArrayList<PGModule> list = new ArrayList<PGModule>();

    list.add(new PGModule("Accelerometer"));
    list.add(new PGModule("Camera"));
    list.add(new PGModule("Compass"));
    list.add(new PGModule("Connection"));
    list.add(new PGModule("Contacts"));
    list.add(new PGModule("Device"));
    list.add(new PGModule("Event"));
    list.add(new PGModule("File"));
    list.add(new PGModule("Geolocation"));
    list.add(new PGModule("Media"));
    list.add(new PGModule("Notification"));

    list.add(new PGModule("InAppBrowser"));
    return list;
  }

  @Override
  public void onCellSelected(int index) {
    switch (index) {
      case 0:
        clientFactory.getPlaceController().goTo(new AccelerometerActivity.MyPlace());
        break;

      case 1:
        clientFactory.getPlaceController().goTo(new CameraActivity.MyPlace());
        break;

      case 2:
        clientFactory.getPlaceController().goTo(new CompassActivity.MyPlace());
        break;

      case 3:
        clientFactory.getPlaceController().goTo(new ConnectionActivity.MyPlace());
        break;

      case 4:
        clientFactory.getPlaceController().goTo(new ContactActivity.MyPlace());
        break;

      case 5:
        clientFactory.getPlaceController().goTo(new DeviceActivity.MyPlace());
        break;

      case 6:
        clientFactory.getPlaceController().goTo(new EventActivity.MyPlace());
        break;
      case 7:
        clientFactory.getPlaceController().goTo(new FileActivity.MyPlace());
        break;
      case 8:
        clientFactory.getPlaceController().goTo(new GeolocationActivity.MyPlace());
        break;
      case 9:
        clientFactory.getPlaceController().goTo(new MediaActivity.MyPlace());
        break;
      case 10:
        clientFactory.getPlaceController().goTo(new NotificationActivity.MyPlace());
        break;

      case 11:
        clientFactory.getPlaceController().goTo(new InAppBrowserActivity.MyPlace());
        break;
    }
  }

  @Override
  public void onAboutButton() {
    clientFactory.getPlaceController().goTo(new AboutActivity.MyPlace());
  }
}
