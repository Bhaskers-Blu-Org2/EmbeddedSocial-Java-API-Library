/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * <autogenerated> This file was generated using AutoRest. </autogenerated>
 */

package com.microsoft.embeddedsocial.autorest;

import es_private.com.google.common.reflect.TypeToken;
import com.microsoft.embeddedsocial.autorest.models.ImageType;
import com.microsoft.embeddedsocial.autorest.models.PostImageResponse;
import es_private.com.microsoft.rest.ServiceCall;
import es_private.com.microsoft.rest.ServiceCallback;
import es_private.com.microsoft.rest.ServiceException;
import es_private.com.microsoft.rest.ServiceResponse;
import es_private.com.microsoft.rest.ServiceResponseBuilder;
import es_private.com.microsoft.rest.ServiceResponseCallback;
import java.io.InputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in ImagesOperations.
 */
public final class ImagesOperationsImpl implements ImagesOperations {
    /** The Retrofit service to perform REST calls. */
    private ImagesService service;
    /** The service client containing this operation class. */
    private EmbeddedSocialClient client;

    /**
     * Initializes an instance of ImagesOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ImagesOperationsImpl(Retrofit retrofit, EmbeddedSocialClient client) {
        this.service = retrofit.create(ImagesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ImagesOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ImagesService {
        @Headers("Content-Type: image/gif")
        @POST("v0.7/images/{imageType}")
        Call<ResponseBody> postImage(@Path("imageType") ImageType imageType, @Header("Authorization") String authorization, @Body RequestBody image);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.7/images/{blobHandle}")
        @Streaming
        Call<ResponseBody> getImage(@Path("blobHandle") String blobHandle, @Header("Authorization") String authorization);

    }

    /**
     * Upload a new image.
     * Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.
     *             
     *              - d is 25 pixels wide
     *              - h is 50 pixels wide
     *              - l is 100 pixels wide
     *              - p is 250 pixels wide
     *              - t is 500 pixels wide
     *              - x is 1000 pixels wide
     *             
     *              - ImageType.UserPhoto supports d,h,l,p,t,x
     *              - ImageType.ContentBlob supports d,h,l,p,t,x
     *              - ImageType.AppIcon supports l
     *             
     *              All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Format is: "Scheme CredentialsList". Possible values are:
     - Anon AK=AppKey
     - SocialPlus TK=SessionToken
     - Facebook AK=AppKey|TK=AccessToken
     - Google AK=AppKey|TK=AccessToken
     - Twitter AK=AppKey|RT=RequestToken|TK=AccessToken
     - Microsoft AK=AppKey|TK=AccessToken
     - AADS2S AK=AppKey|[UH=UserHandle]|TK=AADToken
     * @param image MIME encoded contents of the image
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostImageResponse object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PostImageResponse> postImage(ImageType imageType, String authorization, byte[] image) throws ServiceException, IOException, IllegalArgumentException {
        if (imageType == null) {
            throw new IllegalArgumentException("Parameter imageType is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        if (image == null) {
            throw new IllegalArgumentException("Parameter image is required and cannot be null.");
        }
        RequestBody imageConverted = RequestBody.create(MediaType.parse("image/gif"), image);
        Call<ResponseBody> call = service.postImage(imageType, authorization, imageConverted);
        return postImageDelegate(call.execute());
    }

    /**
     * Upload a new image.
     * Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.
     *             
     *              - d is 25 pixels wide
     *              - h is 50 pixels wide
     *              - l is 100 pixels wide
     *              - p is 250 pixels wide
     *              - t is 500 pixels wide
     *              - x is 1000 pixels wide
     *             
     *              - ImageType.UserPhoto supports d,h,l,p,t,x
     *              - ImageType.ContentBlob supports d,h,l,p,t,x
     *              - ImageType.AppIcon supports l
     *             
     *              All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Format is: "Scheme CredentialsList". Possible values are:
     - Anon AK=AppKey
     - SocialPlus TK=SessionToken
     - Facebook AK=AppKey|TK=AccessToken
     - Google AK=AppKey|TK=AccessToken
     - Twitter AK=AppKey|RT=RequestToken|TK=AccessToken
     - Microsoft AK=AppKey|TK=AccessToken
     - AADS2S AK=AppKey|[UH=UserHandle]|TK=AADToken
     * @param image MIME encoded contents of the image
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall postImageAsync(ImageType imageType, String authorization, byte[] image, final ServiceCallback<PostImageResponse> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (imageType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter imageType is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        if (image == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter image is required and cannot be null."));
            return null;
        }
        RequestBody imageConverted = RequestBody.create(MediaType.parse("image/gif"), image);
        Call<ResponseBody> call = service.postImage(imageType, authorization, imageConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<PostImageResponse>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(postImageDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PostImageResponse> postImageDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<PostImageResponse, ServiceException>(this.client.getMapperAdapter())
                .register(201, new TypeToken<PostImageResponse>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param authorization Format is: "Scheme CredentialsList". Possible values are:
     - Anon AK=AppKey
     - SocialPlus TK=SessionToken
     - Facebook AK=AppKey|TK=AccessToken
     - Google AK=AppKey|TK=AccessToken
     - Twitter AK=AppKey|RT=RequestToken|TK=AccessToken
     - Microsoft AK=AppKey|TK=AccessToken
     - AADS2S AK=AppKey|[UH=UserHandle]|TK=AADToken
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<InputStream> getImage(String blobHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (blobHandle == null) {
            throw new IllegalArgumentException("Parameter blobHandle is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getImage(blobHandle, authorization);
        return getImageDelegate(call.execute());
    }

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param authorization Format is: "Scheme CredentialsList". Possible values are:
     - Anon AK=AppKey
     - SocialPlus TK=SessionToken
     - Facebook AK=AppKey|TK=AccessToken
     - Google AK=AppKey|TK=AccessToken
     - Twitter AK=AppKey|RT=RequestToken|TK=AccessToken
     - Microsoft AK=AppKey|TK=AccessToken
     - AADS2S AK=AppKey|[UH=UserHandle]|TK=AADToken
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getImageAsync(String blobHandle, String authorization, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (blobHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter blobHandle is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getImage(blobHandle, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<InputStream>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getImageDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<InputStream> getImageDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<InputStream, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<InputStream>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}
