package com.googlecode.gwtphonegap.showcase.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
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
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationActivity;

public class TabletMainActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	private Place lastPlace;
	private Activity lastActivity;

	public TabletMainActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}

	@Override
	public Activity getActivity(Place place) {
		Activity activity = getActivity(lastPlace, place);
		lastPlace = place;
		lastActivity = activity;
		return activity;

	}

	private Activity getActivity(Place lastPlace, Place newPlace) {

		if (newPlace instanceof AccelerometerActivity.MyPlace) {
			if (lastPlace instanceof AccelerometerActivity.MyPlace) {
				return lastActivity;
			}
			return new AccelerometerActivity(clientFactory);
		}

		if (newPlace instanceof CameraActivity.MyPlace) {
			if (lastPlace instanceof CameraActivity.MyPlace) {
				return lastActivity;
			}
			return new CameraActivity(clientFactory);
		}

		if (newPlace instanceof CompassActivity.MyPlace) {
			if (lastPlace instanceof CompassActivity.MyPlace) {
				return lastActivity;
			}
			return new CompassActivity(clientFactory);
		}

		if (newPlace instanceof ConnectionActivity.MyPlace) {
			if (lastPlace instanceof ConnectionActivity.MyPlace) {
				return lastActivity;
			}
			return new ConnectionActivity(clientFactory);
		}

		if (newPlace instanceof ContactActivity.MyPlace) {
			if (lastPlace instanceof ContactActivity.MyPlace) {
				return lastActivity;
			}
			return new ContactActivity(clientFactory);
		}

		if (newPlace instanceof DeviceActivity.MyPlace) {
			if (lastPlace instanceof DeviceActivity.MyPlace) {
				return lastActivity;
			}
			return new DeviceActivity(clientFactory);
		}

		if (newPlace instanceof EventActivity.MyPlace) {
			if (lastPlace instanceof EventActivity.MyPlace) {
				return lastActivity;
			}
			return new EventActivity(clientFactory);
		}

		if (newPlace instanceof GeolocationActivity.MyPlace) {
			if (lastPlace instanceof GeolocationActivity.MyPlace) {
				return lastActivity;
			}
			return new GeolocationActivity(clientFactory);
		}

		if (newPlace instanceof MediaActivity.MyPlace) {
			if (lastPlace instanceof MediaActivity.MyPlace) {
				return lastActivity;
			}
			return new MediaActivity(clientFactory);
		}

		if (newPlace instanceof NotificationActivity.MyPlace) {
			if (lastPlace instanceof NotificationActivity.MyPlace) {
				return lastActivity;
			}
			return new NotificationActivity(clientFactory);
		}

		if (newPlace instanceof InAppBrowserActivity.MyPlace) {
			if (lastPlace instanceof InAppBrowserActivity.MyPlace) {
				return lastActivity;
			}
			return new InAppBrowserActivity(clientFactory);
		}

		if (newPlace instanceof AboutActivity.MyPlace || newPlace instanceof OverviewPlace) {
			if (lastPlace instanceof AboutActivity.MyPlace || lastPlace instanceof OverviewPlace) {
				return lastActivity;
			}
			return new AboutActivity(clientFactory.getPlaceController());
		}

		if (newPlace instanceof FileActivity.MyPlace) {
			if (lastPlace instanceof FileActivity.MyPlace) {
				return lastActivity;
			}
			return new FileActivity(clientFactory);
		}
		return null;
	}
}
