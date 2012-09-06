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

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;

@Kroll.module(name="Adstirsdk", id="com.ad_stir.ti")
public class AdstirsdkModule extends KrollModule
{
	public AdstirsdkModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
	}

	@Override
	public void onDestroy(android.app.Activity activity){
		com.ngigroup.adstir.AdstirTerminate.init(activity);
		super.onDestroy(activity);
	}
	
}

