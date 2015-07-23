package com.htech.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.hemant.directory.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * https://www.youtube.com/watch?v=myWu-q8Q2NA
 * https://github.com/slidenerd/FaceBookv4.0HelloWorld/blob/master/app/src/main/java/vivz/slidenerd/facebookv40helloworld/FragmentSimpleLoginButton.java
 *
 * facebook profile image view  http://stackoverflow.com/questions/19855072/android-get-facebook-profile-picture
 */
public class LoginActivityFragment extends Fragment {

    private ImageView mivProfilePic;
    private TextView mTextDetails;
    private CallbackManager mCallbackManager;
    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;
    private String TAG = LoginActivityFragment.class.getSimpleName();
    private ProfilePictureView mivFacebookProfile;

    private FacebookCallback<LoginResult> mFacebookCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.d(TAG, "onSuccess");
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
            mTextDetails.setText(constructWelcomeMessage(profile));

        }




        @Override
        public void onCancel() {
            Log.d(TAG, "onCancel");
        }


        @Override
        public void onError(FacebookException e) {
            Log.d(TAG, "onError " + e);
        }
    };


    public LoginActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mCallbackManager = CallbackManager.Factory.create();
        setupTokenTracker();
        setupProfileTracker();


        mTokenTracker.startTracking();
        mProfileTracker.startTracking();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setupTextDetails(view);
        setupProfilePic(view);
        setupFacebookProfilePic(view);
        setupLoginButton(view);
    }


    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        mTextDetails.setText(constructWelcomeMessage(profile));
        if(profile!=null)
        {
            Uri picUri = profile.getProfilePictureUri(100, 100);
            Log.d(TAG,"profile pic: "+picUri);
            if(picUri!=null)
            {
                Picasso.with(getActivity()).load(picUri).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE) .into(mivProfilePic);
            }

            mivFacebookProfile.setProfileId(profile.getId());
        }

    }


    @Override
    public void onStop() {
        super.onStop();
        mTokenTracker.stopTracking();
        mProfileTracker.stopTracking();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void setupProfilePic(View view) {
        mivProfilePic = (ImageView) view.findViewById(R.id.frag_login_ivProfile);
    }
    public void setupFacebookProfilePic(View view) {
        mivFacebookProfile = (ProfilePictureView) view.findViewById(R.id.frag_login_ivFacebookProfile);
    }

    private void setupTextDetails(View view) {
        mTextDetails = (TextView) view.findViewById(R.id.text_details);
    }


    private void setupTokenTracker() {
        mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                Log.d(TAG, "" + currentAccessToken);
            }
        };
    }


    private void setupProfileTracker() {
        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                if(currentProfile!=null)
                {
                    Log.d(TAG, "" + currentProfile);
                    mTextDetails.setText(constructWelcomeMessage(currentProfile));

                    if(currentProfile!=null)
                    {
                        Uri picUri = currentProfile.getProfilePictureUri(100, 100);
                        if(picUri!=null)
                        {
                            Picasso.with(getActivity()).load(picUri).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE) .into(mivProfilePic);
                        }

                    }
                }
            }
        };
    }


    private void setupLoginButton(View view) {
        LoginButton mButtonLogin = (LoginButton) view.findViewById(R.id.login_button);
        mButtonLogin.setFragment(this);
        mButtonLogin.setReadPermissions("user_friends");
        mButtonLogin.registerCallback(mCallbackManager, mFacebookCallback);
    }


    private String constructWelcomeMessage(Profile profile) {
        StringBuffer stringBuffer = new StringBuffer();
        if (profile != null) {
            stringBuffer.append("Welcome " + profile.getName());
        }
        return stringBuffer.toString();
    }

}