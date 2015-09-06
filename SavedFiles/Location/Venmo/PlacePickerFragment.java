package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import com.facebook.AppEventsLogger;
import com.facebook.Request;
import com.facebook.Request.GraphPlaceListCallback;
import com.facebook.Session;
import com.facebook.android.R.id;
import com.facebook.android.R.layout;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.internal.Utility;
import com.facebook.model.GraphPlace;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;

public class PlacePickerFragment extends PickerFragment<GraphPlace>
{
  private static final String CATEGORY = "category";
  public static final int DEFAULT_RADIUS_IN_METERS = 1000;
  public static final int DEFAULT_RESULTS_LIMIT = 100;
  private static final String ID = "id";
  private static final String LOCATION = "location";
  public static final String LOCATION_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.Location";
  private static final String NAME = "name";
  public static final String RADIUS_IN_METERS_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.RadiusInMeters";
  public static final String RESULTS_LIMIT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ResultsLimit";
  public static final String SEARCH_TEXT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.SearchText";
  public static final String SHOW_SEARCH_BOX_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ShowSearchBox";
  private static final String TAG = "PlacePickerFragment";
  private static final String WERE_HERE_COUNT = "were_here_count";
  private static final int searchTextTimerDelayInMilliseconds = 2000;
  private boolean hasSearchTextChangedSinceLastQuery;
  private Location location;
  private int radiusInMeters;
  private int resultsLimit;
  private EditText searchBox;
  private String searchText;
  private Timer searchTextTimer;
  private boolean showSearchBox;

  public PlacePickerFragment()
  {
    this(localBundle);
  }

  public PlacePickerFragment(Bundle paramBundle)
  {
    super(localGraphPlace, j, paramBundle);
    int i = 1000;
    this.radiusInMeters = i;
    i = 100;
    this.resultsLimit = i;
    i = 1;
    this.showSearchBox = i;
    setPlacePickerSettingsFromBundle(paramBundle);
  }

  PickerFragment<GraphPlace>.PickerFragment.PickerFragmentAdapter<GraphPlace> createAdapter()
  {
    PlacePickerFragment.1 local1 = new com/facebook/widget/PlacePickerFragment$1;
    FragmentActivity localFragmentActivity = getActivity();
    local1.<init>(this, localFragmentActivity);
    boolean bool = false;
    local1.setShowCheckbox(bool);
    bool = getShowPictures();
    local1.setShowPicture(bool);
    return local1;
  }

  PickerFragment<GraphPlace>.PickerFragment.LoadingStrategy createLoadingStrategy()
  {
    PlacePickerFragment.AsNeededLoadingStrategy localAsNeededLoadingStrategy = new com/facebook/widget/PlacePickerFragment$AsNeededLoadingStrategy;
    PlacePickerFragment.1 local1 = null;
    localAsNeededLoadingStrategy.<init>(this, local1);
    return localAsNeededLoadingStrategy;
  }

  private Request createRequest(Location paramLocation, int paramInt1, int paramInt2, String paramString, Set<String> paramSet, Session paramSession)
  {
    Request.GraphPlaceListCallback localGraphPlaceListCallback = null;
    Session localSession = paramSession;
    Object localObject2 = paramLocation;
    int j = paramInt1;
    int k = paramInt2;
    String str1 = paramString;
    Request localRequest = Request.newPlacesSearchRequest(localSession, (Location)localObject2, j, k, str1, localGraphPlaceListCallback);
    HashSet localHashSet = new java/util/HashSet;
    Set<String> localSet = paramSet;
    localHashSet.<init>(localSet);
    int i = 5;
    String[] arrayOfString = new String[i];
    i = 0;
    localObject2 = "id";
    arrayOfString[i] = localObject2;
    i = 1;
    localObject2 = "name";
    arrayOfString[i] = localObject2;
    i = 2;
    localObject2 = "location";
    arrayOfString[i] = localObject2;
    i = 3;
    localObject2 = "category";
    arrayOfString[i] = localObject2;
    i = 4;
    localObject2 = "were_here_count";
    arrayOfString[i] = localObject2;
    Object localObject1 = Arrays.asList(arrayOfString);
    localHashSet.addAll((Collection)localObject1);
    localObject1 = this.adapter;
    String str2 = ((GraphObjectAdapter)localObject1).getPictureFieldSpecifier();
    if (str2 != null)
      localHashSet.add(str2);
    Bundle localBundle = localRequest.getParameters();
    localObject1 = "fields";
    localObject2 = ",";
    localObject2 = TextUtils.join((CharSequence)localObject2, localHashSet);
    localBundle.putString((String)localObject1, (String)localObject2);
    localRequest.setParameters(localBundle);
    return localRequest;
  }

  private Timer createSearchTextTimer()
  {
    Timer localTimer = new java/util/Timer;
    localTimer.<init>();
    PlacePickerFragment.2 local2 = new com/facebook/widget/PlacePickerFragment$2;
    local2.<init>(this);
    long l1 = 0L;
    long l2 = 2000L;
    localTimer.schedule(local2, l1, l2);
    return localTimer;
  }

  PickerFragment<GraphPlace>.PickerFragment.SelectionStrategy createSelectionStrategy()
  {
    PickerFragment.SingleSelectionStrategy localSingleSelectionStrategy = new com/facebook/widget/PickerFragment$SingleSelectionStrategy;
    localSingleSelectionStrategy.<init>(this);
    return localSingleSelectionStrategy;
  }

  String getDefaultTitleText()
  {
    int i = R.string.com_facebook_nearby;
    String str = getString(i);
    return str;
  }

  public Location getLocation()
  {
    Location localLocation = this.location;
    return localLocation;
  }

  public int getRadiusInMeters()
  {
    int i = this.radiusInMeters;
    return i;
  }

  Request getRequestForLoadData(Session paramSession)
  {
    Location localLocation = this.location;
    int i = this.radiusInMeters;
    int j = this.resultsLimit;
    String str = this.searchText;
    HashSet localHashSet = this.extraFields;
    Object localObject = this;
    Session localSession = paramSession;
    localObject = ((PlacePickerFragment)localObject).createRequest(localLocation, i, j, str, localHashSet, localSession);
    return localObject;
  }

  public int getResultsLimit()
  {
    int i = this.resultsLimit;
    return i;
  }

  public String getSearchText()
  {
    String str = this.searchText;
    return str;
  }

  public GraphPlace getSelection()
  {
    List localList = getSelectedGraphObjects();
    if (localList != null)
    {
      boolean bool = localList.isEmpty();
      if (!bool)
      {
        localObject = localList.iterator();
        localObject = ((Iterator)localObject).next();
      }
    }
    for (Object localObject = (GraphPlace)localObject; ; localObject = null)
      return localObject;
  }

  void logAppEvents(boolean paramBoolean)
  {
    Object localObject1 = getActivity();
    Object localObject2 = getSession();
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger((Context)localObject1, (Session)localObject2);
    Bundle localBundle = new android/os/Bundle;
    localBundle.<init>();
    String str1;
    if (paramBoolean)
    {
      str1 = "Completed";
      localObject1 = "fb_dialog_outcome";
      localBundle.putString((String)localObject1, str1);
      localObject2 = "num_places_picked";
      localObject1 = getSelection();
      if (localObject1 == null)
        break label105;
    }
    label105: int j;
    for (int i = 1; ; j = 0)
    {
      localBundle.putInt((String)localObject2, i);
      String str2 = "fb_place_picker_usage";
      localObject2 = null;
      localAppEventsLogger.logSdkEvent(str2, (Double)localObject2, localBundle);
      return;
      str1 = "Unknown";
      break;
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    Object localObject2 = this.searchBox;
    if (localObject2 != null)
    {
      localObject2 = getActivity();
      String str = "input_method";
      Object localObject1 = ((FragmentActivity)localObject2).getSystemService(str);
      localObject1 = (InputMethodManager)localObject1;
      localObject2 = this.searchBox;
      int i = 1;
      ((InputMethodManager)localObject1).showSoftInput((View)localObject2, i);
    }
  }

  public void onDetach()
  {
    super.onDetach();
    Object localObject2 = this.searchBox;
    if (localObject2 != null)
    {
      localObject2 = getActivity();
      String str = "input_method";
      Object localObject1 = ((FragmentActivity)localObject2).getSystemService(str);
      localObject1 = (InputMethodManager)localObject1;
      localObject2 = this.searchBox;
      localObject2 = ((EditText)localObject2).getWindowToken();
      int i = 0;
      ((InputMethodManager)localObject1).hideSoftInputFromWindow((IBinder)localObject2, i);
    }
  }

  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    int[] arrayOfInt = R.styleable.com_facebook_place_picker_fragment;
    TypedArray localTypedArray = paramActivity.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    int i = R.styleable.com_facebook_place_picker_fragment_radius_in_meters;
    int m = this.radiusInMeters;
    i = localTypedArray.getInt(i, m);
    setRadiusInMeters(i);
    i = R.styleable.com_facebook_place_picker_fragment_results_limit;
    m = this.resultsLimit;
    i = localTypedArray.getInt(i, m);
    setResultsLimit(i);
    i = R.styleable.com_facebook_place_picker_fragment_results_limit;
    boolean bool1 = localTypedArray.hasValue(i);
    if (bool1)
    {
      int j = R.styleable.com_facebook_place_picker_fragment_search_text;
      String str = localTypedArray.getString(j);
      setSearchText(str);
    }
    int k = R.styleable.com_facebook_place_picker_fragment_show_search_box;
    boolean bool3 = this.showSearchBox;
    boolean bool2 = localTypedArray.getBoolean(k, bool3);
    this.showSearchBox = bool2;
    localTypedArray.recycle();
  }

  void onLoadingData()
  {
    boolean bool = false;
    this.hasSearchTextChangedSinceLastQuery = bool;
  }

  public void onSearchBoxTextChanged(String paramString, boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      String str = this.searchText;
      bool = Utility.stringsEqualOrEmpty(str, paramString);
      if (!bool);
    }
    while (true)
    {
      return;
      bool = TextUtils.isEmpty(paramString);
      if (bool)
        paramString = null;
      this.searchText = paramString;
      bool = true;
      this.hasSearchTextChangedSinceLastQuery = bool;
      Timer localTimer = this.searchTextTimer;
      if (localTimer == null)
      {
        localTimer = createSearchTextTimer();
        this.searchTextTimer = localTimer;
      }
    }
  }

  private void onSearchTextTimerTriggered()
  {
    boolean bool = this.hasSearchTextChangedSinceLastQuery;
    Object localObject;
    if (bool)
    {
      Handler localHandler = new android/os/Handler;
      localObject = Looper.getMainLooper();
      localHandler.<init>((Looper)localObject);
      localObject = new com/facebook/widget/PlacePickerFragment$3;
      ((PlacePickerFragment.3)localObject).<init>(this);
      localHandler.post((Runnable)localObject);
    }
    while (true)
    {
      return;
      localObject = this.searchTextTimer;
      ((Timer)localObject).cancel();
      localObject = null;
      this.searchTextTimer = ((Timer)localObject);
    }
  }

  void saveSettingsToBundle(Bundle paramBundle)
  {
    super.saveSettingsToBundle(paramBundle);
    String str = "com.facebook.widget.PlacePickerFragment.RadiusInMeters";
    int i = this.radiusInMeters;
    paramBundle.putInt(str, i);
    str = "com.facebook.widget.PlacePickerFragment.ResultsLimit";
    i = this.resultsLimit;
    paramBundle.putInt(str, i);
    str = "com.facebook.widget.PlacePickerFragment.SearchText";
    Object localObject = this.searchText;
    paramBundle.putString(str, (String)localObject);
    str = "com.facebook.widget.PlacePickerFragment.Location";
    localObject = this.location;
    paramBundle.putParcelable(str, (Parcelable)localObject);
    str = "com.facebook.widget.PlacePickerFragment.ShowSearchBox";
    boolean bool = this.showSearchBox;
    paramBundle.putBoolean(str, bool);
  }

  public void setLocation(Location paramLocation)
  {
    this.location = paramLocation;
  }

  private void setPlacePickerSettingsFromBundle(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str1 = "com.facebook.widget.PlacePickerFragment.RadiusInMeters";
      int k = this.radiusInMeters;
      int i = paramBundle.getInt(str1, k);
      setRadiusInMeters(i);
      String str2 = "com.facebook.widget.PlacePickerFragment.ResultsLimit";
      k = this.resultsLimit;
      int j = paramBundle.getInt(str2, k);
      setResultsLimit(j);
      String str3 = "com.facebook.widget.PlacePickerFragment.SearchText";
      boolean bool1 = paramBundle.containsKey(str3);
      if (bool1)
      {
        str4 = "com.facebook.widget.PlacePickerFragment.SearchText";
        str4 = paramBundle.getString(str4);
        setSearchText(str4);
      }
      String str4 = "com.facebook.widget.PlacePickerFragment.Location";
      boolean bool2 = paramBundle.containsKey(str4);
      if (bool2)
      {
        str5 = "com.facebook.widget.PlacePickerFragment.Location";
        Object localObject = paramBundle.getParcelable(str5);
        localObject = (Location)localObject;
        setLocation((Location)localObject);
      }
      String str5 = "com.facebook.widget.PlacePickerFragment.ShowSearchBox";
      boolean bool4 = this.showSearchBox;
      boolean bool3 = paramBundle.getBoolean(str5, bool4);
      this.showSearchBox = bool3;
    }
  }

  public void setRadiusInMeters(int paramInt)
  {
    this.radiusInMeters = paramInt;
  }

  public void setResultsLimit(int paramInt)
  {
    this.resultsLimit = paramInt;
  }

  public void setSearchText(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    if (bool)
      paramString = null;
    this.searchText = paramString;
    EditText localEditText = this.searchBox;
    if (localEditText != null)
    {
      localEditText = this.searchBox;
      localEditText.setText(paramString);
    }
  }

  public void setSettingsFromBundle(Bundle paramBundle)
  {
    super.setSettingsFromBundle(paramBundle);
    setPlacePickerSettingsFromBundle(paramBundle);
  }

  void setupViews(ViewGroup paramViewGroup)
  {
    Object localObject5 = null;
    boolean bool3 = false;
    boolean bool1 = this.showSearchBox;
    if (bool1)
    {
      int i = R.id.com_facebook_picker_list_view;
      Object localObject1 = paramViewGroup.findViewById(i);
      localObject1 = (ListView)localObject1;
      Object localObject2 = getActivity();
      localObject2 = ((FragmentActivity)localObject2).getLayoutInflater();
      int k = R.layout.com_facebook_picker_search_box;
      View localView = ((LayoutInflater)localObject2).inflate(k, (ViewGroup)localObject1, bool3);
      ((ListView)localObject1).addHeaderView(localView, localObject5, bool3);
      int j = R.id.com_facebook_picker_search_text;
      Object localObject3 = paramViewGroup.findViewById(j);
      localObject3 = (EditText)localObject3;
      this.searchBox = ((EditText)localObject3);
      localObject3 = this.searchBox;
      Object localObject4 = new com/facebook/widget/PlacePickerFragment$SearchTextWatcher;
      ((PlacePickerFragment.SearchTextWatcher)localObject4).<init>(this, localObject5);
      ((EditText)localObject3).addTextChangedListener((TextWatcher)localObject4);
      localObject3 = this.searchText;
      boolean bool2 = TextUtils.isEmpty((CharSequence)localObject3);
      if (!bool2)
      {
        EditText localEditText = this.searchBox;
        localObject4 = this.searchText;
        localEditText.setText((CharSequence)localObject4);
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.facebook.widget.PlacePickerFragment
 * JD-Core Version:    0.6.2
 */