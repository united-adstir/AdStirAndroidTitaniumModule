/*
Copyright 2012 motionBEAT Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.ad_stir.ti;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;
import com.ad_stir.AdstirView;
import android.app.Activity;

@Kroll.proxy(creatableInModule=AdstirsdkModule.class)
public class AdstirProxy extends TiViewProxy
{
	private class AdstirViewView extends TiUIView
	{
		private AdstirView adstir;
		public AdstirViewView(TiViewProxy proxy) {
			super(proxy);
			adstir = new AdstirView(proxy.getActivity(), media, spot);
			setNativeView(adstir);
		}

		@Override
		public void processProperties(KrollDict d)
		{
			super.processProperties(d);
		}
	}

	private String media;
	private int spot;

	public AdstirProxy()
	{
		super();
	}

	@Override
	public TiUIView createView(Activity activity)
	{
		TiUIView view = new AdstirViewView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		return view;
	}

	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);
		
		if (options.containsKey("media")) {
			media = options.get("media").toString();
		}
		if (options.containsKey("spot")) {
			String spotString = options.get("spot").toString();
			spot = Integer.parseInt(spotString);
		}
	}

}