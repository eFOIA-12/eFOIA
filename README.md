# eFOIA
Reversed DHA eFOIA app

Downloaded via www.Apkleecher.com.  Didn't verify if it was unaltered.

md5, sha1, sha256 sums of downloaded APK:
ab71bb0b0b37f1385210ae1ff61aba60 *eFOIA 1.2_[www.Apkleecher.com].apk
0ea8fce699091fe1400623604bbeb7e040c506bb *eFOIA 1.2_[www.Apkleecher.com].apk
64c4623cd36135e3fb58a1bdf6a9e7ca994130f48a7089f57dd4675dcf8a9651 *eFOIA 1.2_[www.Apkleecher.com].apk

Quickly reversed with bytecode viewer using fernflower to decompile.


+---.fabric
+---android
|   \---support
|       +---annotation
|       +---v4
|       |   +---accessibilityservice
|       |   +---app
|       |   +---content
|       |   |   +---pm
|       |   |   \---res
|       |   +---database
|       |   +---graphics
|       |   |   \---drawable
|       |   +---hardware
|       |   |   \---display
|       |   +---internal
|       |   |   \---view
|       |   +---media
|       |   |   +---routing
|       |   |   \---session
|       |   +---net
|       |   +---os
|       |   +---print
|       |   +---provider
|       |   +---speech
|       |   |   \---tts
|       |   +---text
|       |   +---util
|       |   +---view
|       |   |   +---accessibility
|       |   |   \---animation
|       |   \---widget
|       \---v7
|           +---app
|           +---appcompat
|           +---graphics
|           |   \---drawable
|           +---internal
|           |   +---app
|           |   +---text
|           |   +---transition
|           |   +---view
|           |   |   \---menu
|           |   \---widget
|           +---view
|           \---widget
+---assets
|   \---fonts
+---com
|   +---androidquery
|   |   +---auth
|   |   +---callback
|   |   +---service
|   |   \---util
|   +---crashlytics
|   |   \---android
|   |       +---answers
|   |       +---beta
|   |       \---core
|   |           \---internal
|   |               \---models
|   +---google
|   |   +---ads
|   |   |   \---mediation
|   |   |       +---admob
|   |   |       \---customevent
|   |   +---android
|   |   |   \---gms
|   |   |       +---actions
|   |   |       +---ads
|   |   |       |   +---doubleclick
|   |   |       |   +---identifier
|   |   |       |   +---mediation
|   |   |       |   |   +---admob
|   |   |       |   |   \---customevent
|   |   |       |   +---purchase
|   |   |       |   \---search
|   |   |       +---analytics
|   |   |       |   \---ecommerce
|   |   |       +---appindexing
|   |   |       +---appstate
|   |   |       +---auth
|   |   |       +---cast
|   |   |       +---common
|   |   |       |   +---annotation
|   |   |       |   +---api
|   |   |       |   +---data
|   |   |       |   +---images
|   |   |       |   \---internal
|   |   |       |       \---safeparcel
|   |   |       +---deviceconnection
|   |   |       |   \---features
|   |   |       +---drive
|   |   |       |   +---events
|   |   |       |   +---internal
|   |   |       |   +---metadata
|   |   |       |   |   \---internal
|   |   |       |   +---query
|   |   |       |   |   \---internal
|   |   |       |   +---realtime
|   |   |       |   |   \---internal
|   |   |       |   |       \---event
|   |   |       |   \---widget
|   |   |       +---dynamic
|   |   |       +---fitness
|   |   |       |   +---data
|   |   |       |   +---request
|   |   |       |   +---result
|   |   |       |   \---service
|   |   |       +---games
|   |   |       |   +---achievement
|   |   |       |   +---appcontent
|   |   |       |   +---event
|   |   |       |   +---internal
|   |   |       |   |   +---api
|   |   |       |   |   +---constants
|   |   |       |   |   +---data
|   |   |       |   |   +---events
|   |   |       |   |   +---experience
|   |   |       |   |   +---game
|   |   |       |   |   +---multiplayer
|   |   |       |   |   +---notification
|   |   |       |   |   +---player
|   |   |       |   |   \---request
|   |   |       |   +---leaderboard
|   |   |       |   +---multiplayer
|   |   |       |   |   +---realtime
|   |   |       |   |   \---turnbased
|   |   |       |   +---quest
|   |   |       |   +---request
|   |   |       |   \---snapshot
|   |   |       +---gcm
|   |   |       +---identity
|   |   |       |   \---intents
|   |   |       |       \---model
|   |   |       +---internal
|   |   |       +---location
|   |   |       +---maps
|   |   |       |   +---internal
|   |   |       |   \---model
|   |   |       |       \---internal
|   |   |       +---panorama
|   |   |       +---plus
|   |   |       |   +---internal
|   |   |       |   \---model
|   |   |       |       +---moments
|   |   |       |       \---people
|   |   |       +---security
|   |   |       +---tagmanager
|   |   |       +---wallet
|   |   |       |   +---fragment
|   |   |       |   \---wobs
|   |   |       \---wearable
|   |   |           \---internal
|   |   \---gson
|   |       +---annotations
|   |       +---internal
|   |       |   \---bind
|   |       +---reflect
|   |       \---stream
|   \---parallel6
|       +---captivereachconnectsdk
|       |   +---builders
|       |   +---cache
|       |   +---enums
|       |   +---gcm
|       |   +---gps
|       |   +---helpers
|       |   +---log
|       |   +---models
|       |   |   +---filters
|       |   |   +---json
|       |   |   |   +---request
|       |   |   |   \---response
|       |   |   +---login
|       |   |   \---surveys
|       |   +---network
|       |   |   +---http
|       |   |   +---login
|       |   |   \---request
|       |   +---services
|       |   \---utils
|       \---ui
|           +---actions
|           +---activities
|           +---adapters
|           |   +---base
|           |   +---list
|           |   \---pager
|           +---broadcast
|           +---configurability
|           |   +---adapters
|           |   +---enums
|           |   +---fragments
|           |   |   +---detail
|           |   |   \---undefined
|           |   +---interfaces
|           |   +---models
|           |   \---widgets
|           +---controllers
|           +---database
|           |   \---my_calendar
|           +---dialogs
|           +---enums
|           |   \---styles
|           +---fragments
|           |   +---base
|           |   +---calendar
|           |   +---detail
|           |   +---factories
|           |   +---home
|           |   +---list
|           |   |   \---pager
|           |   \---maps
|           +---interfaces
|           +---models
|           +---surveys
|           |   +---adapters
|           |   +---fragments
|           |   +---interfaces
|           |   +---network
|           |   \---views
|           +---utils
|           \---widgets
|               \---calendar
+---Decoded Resources
|   +---assets
|   |   \---fonts
|   +---res
|   |   +---anim
|   |   +---animator
|   |   +---color
|   |   +---color-v11
|   |   +---drawable
|   |   +---drawable-hdpi
|   |   +---drawable-ldrtl-hdpi-v17
|   |   +---drawable-ldrtl-mdpi-v17
|   |   +---drawable-ldrtl-xhdpi-v17
|   |   +---drawable-ldrtl-xxhdpi-v17
|   |   +---drawable-ldrtl-xxxhdpi-v17
|   |   +---drawable-mdpi
|   |   +---drawable-tvdpi
|   |   +---drawable-xhdpi
|   |   +---drawable-xxhdpi
|   |   +---drawable-xxxhdpi
|   |   +---layout
|   |   +---layout-v11
|   |   +---layout-v21
|   |   +---mipmap-hdpi
|   |   +---mipmap-mdpi
|   |   +---mipmap-xhdpi
|   |   +---mipmap-xxhdpi
|   |   +---raw
|   |   +---values
|   |   +---values-af
|   |   +---values-am
|   |   +---values-ar
|   |   +---values-bg
|   |   +---values-bn-rBD
|   |   +---values-ca
|   |   +---values-cs
|   |   +---values-da
|   |   +---values-de
|   |   +---values-el
|   |   +---values-en-rGB
|   |   +---values-en-rIN
|   |   +---values-es
|   |   +---values-es-rUS
|   |   +---values-et-rEE
|   |   +---values-eu-rES
|   |   +---values-fa
|   |   +---values-fi
|   |   +---values-fr
|   |   +---values-fr-rCA
|   |   +---values-gl-rES
|   |   +---values-h720dp
|   |   +---values-hdpi
|   |   +---values-hi
|   |   +---values-hr
|   |   +---values-hu
|   |   +---values-hy-rAM
|   |   +---values-in
|   |   +---values-is-rIS
|   |   +---values-it
|   |   +---values-iw
|   |   +---values-ja
|   |   +---values-ka-rGE
|   |   +---values-kk-rKZ
|   |   +---values-km-rKH
|   |   +---values-kn-rIN
|   |   +---values-ko
|   |   +---values-ky-rKG
|   |   +---values-land
|   |   +---values-large
|   |   +---values-lo-rLA
|   |   +---values-lt
|   |   +---values-lv
|   |   +---values-mk-rMK
|   |   +---values-ml-rIN
|   |   +---values-mn-rMN
|   |   +---values-mr-rIN
|   |   +---values-ms-rMY
|   |   +---values-my-rMM
|   |   +---values-nb
|   |   +---values-ne-rNP
|   |   +---values-nl
|   |   +---values-pl
|   |   +---values-port
|   |   +---values-pt
|   |   +---values-pt-rBR
|   |   +---values-pt-rPT
|   |   +---values-ro
|   |   +---values-ru
|   |   +---values-si-rLK
|   |   +---values-sk
|   |   +---values-sl
|   |   +---values-sr
|   |   +---values-sv
|   |   +---values-sw
|   |   +---values-sw600dp
|   |   +---values-ta-rIN
|   |   +---values-te-rIN
|   |   +---values-th
|   |   +---values-tl
|   |   +---values-tr
|   |   +---values-uk
|   |   +---values-ur-rPK
|   |   +---values-uz-rUZ
|   |   +---values-v11
|   |   +---values-v12
|   |   +---values-v14
|   |   +---values-v17
|   |   +---values-v18
|   |   +---values-v21
|   |   +---values-vi
|   |   +---values-w360dp
|   |   +---values-w480dp
|   |   +---values-w500dp
|   |   +---values-w600dp
|   |   +---values-w720dp
|   |   +---values-w820dp
|   |   +---values-xlarge
|   |   +---values-xlarge-land
|   |   +---values-zh-rCN
|   |   +---values-zh-rHK
|   |   +---values-zh-rTW
|   |   \---values-zu
|   \---unknown
|       +---.fabric
|       \---org
|           \---apache
|               \---http
|                   \---entity
|                       \---mime
+---gov
|   \---dhs
|       \---mobile
|           \---efoia
|               +---arrayadapters
|               +---datastructures
|               +---models
|               +---tasks
|               +---viewcontrollers
|               |   +---eventdetails
|               |   +---events
|               |   +---exemptions
|               |   +---feestructure
|               |   +---fivesteps
|               |   +---howto
|               |   +---library
|               |   +---limits
|               |   +---privacyact
|               |   +---privacypolicy
|               |   +---privacystatement
|               |   +---processing
|               |   +---status
|               |   +---statutes
|               |   \---submission
|               |       +---step1
|               |       +---step2
|               |       +---step3
|               |       +---step4
|               |       +---step5
|               |       +---step6
|               |       +---step7
|               |       \---step8
|               \---webview
+---io
|   \---fabric
|       \---sdk
|           \---android
|               \---services
|                   +---cache
|                   +---common
|                   +---concurrency
|                   |   \---internal
|                   +---events
|                   +---network
|                   +---persistence
|                   \---settings
+---org
|   \---apache
|       \---http
|           +---annotation
|           +---concurrent
|           +---config
|           +---entity
|           |   \---mime
|           |       \---content
|           +---impl
|           |   +---entity
|           |   +---io
|           |   \---pool
|           +---io
|           +---message
|           +---params
|           +---pool
|           +---protocol
|           \---util
\---res
    +---anim
    +---animator
    +---color
    +---color-v11
    +---drawable
    +---drawable-hdpi-v4
    +---drawable-ldrtl-hdpi-v17
    +---drawable-ldrtl-mdpi-v17
    +---drawable-ldrtl-xhdpi-v17
    +---drawable-ldrtl-xxhdpi-v17
    +---drawable-ldrtl-xxxhdpi-v17
    +---drawable-mdpi-v4
    +---drawable-tvdpi-v4
    +---drawable-xhdpi-v4
    +---drawable-xxhdpi-v4
    +---drawable-xxxhdpi-v4
    +---layout
    +---layout-v11
    +---layout-v21
    +---mipmap-hdpi-v4
    +---mipmap-mdpi-v4
    +---mipmap-xhdpi-v4
    +---mipmap-xxhdpi-v4
    \---raw



Following files contain decompilation failures:
./android/support/v4/app/Fragment.java
./android/support/v4/app/FragmentActivity.java
./android/support/v4/app/FragmentManagerImpl.java
./android/support/v4/app/INotificationSideChannel.java
./android/support/v4/app/NotificationCompatJellybean.java
./android/support/v4/app/NotificationManagerCompat.java
./android/support/v4/app/TaskStackBuilder.java
./android/support/v4/content/ContextCompat.java
./android/support/v4/content/FileProvider.java
./android/support/v4/content/LocalBroadcastManager.java
./android/support/v4/content/WakefulBroadcastReceiver.java
./android/support/v4/hardware/display/DisplayManagerCompat.java
./android/support/v4/media/session/IMediaControllerCallback.java
./android/support/v4/media/session/IMediaSession.java
./android/support/v4/media/session/MediaSessionCompat.java
./android/support/v4/print/PrintHelperKitkat.java
./android/support/v4/provider/DocumentsContractApi19.java
./android/support/v4/provider/DocumentsContractApi21.java
./android/support/v4/text/ICUCompatIcs.java
./android/support/v4/util/AtomicFile.java
./android/support/v4/util/LongSparseArray.java
./android/support/v4/util/LruCache.java
./android/support/v4/util/Pools.java
./android/support/v4/util/SimpleArrayMap.java
./android/support/v4/util/SparseArrayCompat.java
./android/support/v4/util/TimeUtils.java
./android/support/v7/internal/app/AppCompatViewInflater.java
./android/support/v7/internal/view/SupportMenuInflater.java
./android/support/v7/internal/widget/ActivityChooserModel.java
./android/support/v7/internal/widget/AppCompatPopupWindow.java
./android/support/v7/internal/widget/DrawableUtils.java
./android/support/v7/internal/widget/ListViewCompat.java
./android/support/v7/widget/SearchView.java
./android/support/v7/widget/SuggestionsAdapter.java
./com/androidquery/AbstractAQuery.java
./com/androidquery/auth/AccountHandle.java
./com/androidquery/callback/AbstractAjaxCallback.java
./com/androidquery/callback/BitmapAjaxCallback.java
./com/androidquery/service/MarketService.java
./com/androidquery/util/AQUtility.java
./com/androidquery/util/XmlDom.java
./com/crashlytics/android/answers/Answers.java
./com/crashlytics/android/beta/Beta.java
./com/crashlytics/android/beta/CheckForUpdatesRequest.java
./com/crashlytics/android/beta/DeviceTokenLoader.java
./com/crashlytics/android/core/ClsFileOutputStream.java
./com/crashlytics/android/core/CrashlyticsCore.java
./com/crashlytics/android/core/ExceptionUtils.java
./com/crashlytics/android/core/LogFileManager.java
./com/crashlytics/android/core/ReportUploader.java
./com/google/android/gms/ads/identifier/AdvertisingIdClient.java
./com/google/android/gms/analytics/a.java
./com/google/android/gms/analytics/ad.java
./com/google/android/gms/analytics/ae.java
./com/google/android/gms/analytics/ag.java
./com/google/android/gms/analytics/ai.java
./com/google/android/gms/analytics/g.java
./com/google/android/gms/analytics/GoogleAnalytics.java
./com/google/android/gms/analytics/h.java
./com/google/android/gms/analytics/k.java
./com/google/android/gms/analytics/n.java
./com/google/android/gms/analytics/StandardExceptionParser.java
./com/google/android/gms/analytics/v.java
./com/google/android/gms/analytics/x.java
./com/google/android/gms/analytics/y.java
./com/google/android/gms/auth/GoogleAuthUtil.java
./com/google/android/gms/cast/MediaInfo.java
./com/google/android/gms/cast/MediaMetadata.java
./com/google/android/gms/cast/MediaTrack.java
./com/google/android/gms/cast/RemoteMediaPlayer.java
./com/google/android/gms/cast/TextTrackStyle.java
./com/google/android/gms/common/api/BaseImplementation.java
./com/google/android/gms/common/api/Batch.java
./com/google/android/gms/common/api/c.java
./com/google/android/gms/common/data/DataBufferUtils.java
./com/google/android/gms/common/data/DataHolder.java
./com/google/android/gms/common/data/g.java
./com/google/android/gms/common/GooglePlayServicesUtil.java
./com/google/android/gms/common/images/ImageManager.java
./com/google/android/gms/drive/events/DriveEventService.java
./com/google/android/gms/drive/internal/ae.java
./com/google/android/gms/drive/internal/af.java
./com/google/android/gms/drive/internal/ag.java
./com/google/android/gms/drive/internal/ah.java
./com/google/android/gms/drive/realtime/internal/c.java
./com/google/android/gms/drive/realtime/internal/d.java
./com/google/android/gms/drive/realtime/internal/e.java
./com/google/android/gms/drive/realtime/internal/f.java
./com/google/android/gms/drive/realtime/internal/g.java
./com/google/android/gms/drive/realtime/internal/h.java
./com/google/android/gms/drive/realtime/internal/i.java
./com/google/android/gms/drive/realtime/internal/j.java
./com/google/android/gms/drive/realtime/internal/k.java
./com/google/android/gms/drive/realtime/internal/l.java
./com/google/android/gms/drive/realtime/internal/m.java
./com/google/android/gms/drive/realtime/internal/n.java
./com/google/android/gms/drive/realtime/internal/o.java
./com/google/android/gms/dynamic/c.java
./com/google/android/gms/fitness/data/k.java
./com/google/android/gms/fitness/data/l.java
./com/google/android/gms/fitness/request/a.java
./com/google/android/gms/fitness/request/l.java
./com/google/android/gms/games/internal/GamesClientImpl.java
./com/google/android/gms/games/internal/IGamesCallbacks.java
./com/google/android/gms/games/internal/IGamesService.java
./com/google/android/gms/games/internal/IGamesSignInCallbacks.java
./com/google/android/gms/games/internal/IGamesSignInService.java
./com/google/android/gms/games/internal/IRoomService.java
./com/google/android/gms/games/internal/IRoomServiceCallbacks.java
./com/google/android/gms/games/snapshot/SnapshotContentsEntity.java
./com/google/android/gms/gcm/GoogleCloudMessaging.java
./com/google/android/gms/internal/ae.java
./com/google/android/gms/internal/ak.java
./com/google/android/gms/internal/al.java
./com/google/android/gms/internal/am.java
./com/google/android/gms/internal/an.java
./com/google/android/gms/internal/ao.java
./com/google/android/gms/internal/ar.java
./com/google/android/gms/internal/bb.java
./com/google/android/gms/internal/bd.java
./com/google/android/gms/internal/be.java
./com/google/android/gms/internal/bh.java
./com/google/android/gms/internal/bi.java
./com/google/android/gms/internal/bq.java
./com/google/android/gms/internal/br.java
./com/google/android/gms/internal/bt.java
./com/google/android/gms/internal/bu.java
./com/google/android/gms/internal/c.java
./com/google/android/gms/internal/cc.java
./com/google/android/gms/internal/ck.java
./com/google/android/gms/internal/ct.java
./com/google/android/gms/internal/cz.java
./com/google/android/gms/internal/d.java
./com/google/android/gms/internal/dc.java
./com/google/android/gms/internal/de.java
./com/google/android/gms/internal/dp.java
./com/google/android/gms/internal/dx.java
./com/google/android/gms/internal/dy.java
./com/google/android/gms/internal/ec.java
./com/google/android/gms/internal/ee.java
./com/google/android/gms/internal/eh.java
./com/google/android/gms/internal/en.java
./com/google/android/gms/internal/eo.java
./com/google/android/gms/internal/ep.java
./com/google/android/gms/internal/er.java
./com/google/android/gms/internal/fb.java
./com/google/android/gms/internal/ff.java
./com/google/android/gms/internal/fl.java
./com/google/android/gms/internal/fn.java
./com/google/android/gms/internal/fr.java
./com/google/android/gms/internal/fs.java
./com/google/android/gms/internal/fv.java
./com/google/android/gms/internal/fz.java
./com/google/android/gms/internal/ga.java
./com/google/android/gms/internal/gb.java
./com/google/android/gms/internal/gd.java
./com/google/android/gms/internal/ge.java
./com/google/android/gms/internal/gj.java
./com/google/android/gms/internal/gn.java
./com/google/android/gms/internal/gp.java
./com/google/android/gms/internal/gu.java
./com/google/android/gms/internal/gw.java
./com/google/android/gms/internal/h.java
./com/google/android/gms/internal/hu.java
./com/google/android/gms/internal/hv.java
./com/google/android/gms/internal/i.java
./com/google/android/gms/internal/ib.java
./com/google/android/gms/internal/ic.java
./com/google/android/gms/internal/id.java
./com/google/android/gms/internal/ih.java
./com/google/android/gms/internal/im.java
./com/google/android/gms/internal/iq.java
./com/google/android/gms/internal/it.java
./com/google/android/gms/internal/iw.java
./com/google/android/gms/internal/ix.java
./com/google/android/gms/internal/iy.java
./com/google/android/gms/internal/j.java
./com/google/android/gms/internal/jh.java
./com/google/android/gms/internal/ji.java
./com/google/android/gms/internal/jl.java
./com/google/android/gms/internal/jm.java
./com/google/android/gms/internal/jn.java
./com/google/android/gms/internal/js.java
./com/google/android/gms/internal/jt.java
./com/google/android/gms/internal/ju.java
./com/google/android/gms/internal/k.java
./com/google/android/gms/internal/ki.java
./com/google/android/gms/internal/kj.java
./com/google/android/gms/internal/lh.java
./com/google/android/gms/internal/lw.java
./com/google/android/gms/internal/lx.java
./com/google/android/gms/internal/ly.java
./com/google/android/gms/internal/lz.java
./com/google/android/gms/internal/ma.java
./com/google/android/gms/internal/mb.java
./com/google/android/gms/internal/mc.java
./com/google/android/gms/internal/md.java
./com/google/android/gms/internal/mj.java
./com/google/android/gms/internal/mp.java
./com/google/android/gms/internal/mv.java
./com/google/android/gms/internal/mw.java
./com/google/android/gms/internal/mx.java
./com/google/android/gms/internal/my.java
./com/google/android/gms/internal/nh.java
./com/google/android/gms/internal/ni.java
./com/google/android/gms/internal/nj.java
./com/google/android/gms/internal/nk.java
./com/google/android/gms/internal/og.java
./com/google/android/gms/internal/oj.java
./com/google/android/gms/internal/ok.java
./com/google/android/gms/internal/oq.java
./com/google/android/gms/internal/ox.java
./com/google/android/gms/internal/ph.java
./com/google/android/gms/internal/qa.java
./com/google/android/gms/internal/qb.java
./com/google/android/gms/internal/qc.java
./com/google/android/gms/internal/qd.java
./com/google/android/gms/internal/qe.java
./com/google/android/gms/internal/qf.java
./com/google/android/gms/internal/qm.java
./com/google/android/gms/internal/qr.java
./com/google/android/gms/internal/r.java
./com/google/android/gms/internal/ra.java
./com/google/android/gms/internal/s.java
./com/google/android/gms/location/b.java
./com/google/android/gms/maps/internal/c.java
./com/google/android/gms/maps/internal/d.java
./com/google/android/gms/maps/internal/e.java
./com/google/android/gms/maps/internal/f.java
./com/google/android/gms/maps/internal/g.java
./com/google/android/gms/maps/internal/h.java
./com/google/android/gms/maps/internal/i.java
./com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate.java
./com/google/android/gms/maps/internal/IGoogleMapDelegate.java
./com/google/android/gms/maps/internal/ILocationSourceDelegate.java
./com/google/android/gms/maps/internal/IMapFragmentDelegate.java
./com/google/android/gms/maps/internal/IMapViewDelegate.java
./com/google/android/gms/maps/internal/IProjectionDelegate.java
./com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate.java
./com/google/android/gms/maps/internal/IStreetViewPanoramaFragmentDelegate.java
./com/google/android/gms/maps/internal/IStreetViewPanoramaViewDelegate.java
./com/google/android/gms/maps/internal/IUiSettingsDelegate.java
./com/google/android/gms/maps/internal/j.java
./com/google/android/gms/maps/internal/l.java
./com/google/android/gms/maps/internal/m.java
./com/google/android/gms/maps/internal/n.java
./com/google/android/gms/maps/internal/o.java
./com/google/android/gms/maps/internal/q.java
./com/google/android/gms/maps/internal/r.java
./com/google/android/gms/maps/internal/s.java
./com/google/android/gms/maps/internal/t.java
./com/google/android/gms/maps/internal/u.java
./com/google/android/gms/maps/internal/v.java
./com/google/android/gms/maps/MapFragment.java
./com/google/android/gms/maps/MapView.java
./com/google/android/gms/maps/model/IndoorBuilding.java
./com/google/android/gms/maps/model/internal/g.java
./com/google/android/gms/maps/model/internal/h.java
./com/google/android/gms/maps/model/internal/i.java
./com/google/android/gms/maps/model/internal/IPolylineDelegate.java
./com/google/android/gms/maps/model/internal/j.java
./com/google/android/gms/maps/model/internal/k.java
./com/google/android/gms/maps/model/internal/l.java
./com/google/android/gms/maps/model/internal/m.java
./com/google/android/gms/maps/model/internal/n.java
./com/google/android/gms/maps/StreetViewPanoramaFragment.java
./com/google/android/gms/maps/StreetViewPanoramaView.java
./com/google/android/gms/maps/SupportMapFragment.java
./com/google/android/gms/maps/SupportStreetViewPanoramaFragment.java
./com/google/android/gms/plus/internal/b.java
./com/google/android/gms/plus/internal/c.java
./com/google/android/gms/plus/internal/d.java
./com/google/android/gms/plus/internal/g.java
./com/google/android/gms/plus/PlusOneDummyView.java
./com/google/android/gms/security/ProviderInstaller.java
./com/google/android/gms/tagmanager/a.java
./com/google/android/gms/tagmanager/ay.java
./com/google/android/gms/tagmanager/bf.java
./com/google/android/gms/tagmanager/cb.java
./com/google/android/gms/tagmanager/ce.java
./com/google/android/gms/tagmanager/ch.java
./com/google/android/gms/tagmanager/Container.java
./com/google/android/gms/tagmanager/cq.java
./com/google/android/gms/tagmanager/ct.java
./com/google/android/gms/tagmanager/cw.java
./com/google/android/gms/tagmanager/cy.java
./com/google/android/gms/tagmanager/da.java
./com/google/android/gms/tagmanager/DataLayer.java
./com/google/android/gms/tagmanager/db.java
./com/google/android/gms/tagmanager/dj.java
./com/google/android/gms/tagmanager/i.java
./com/google/android/gms/tagmanager/n.java
./com/google/android/gms/tagmanager/o.java
./com/google/android/gms/tagmanager/PreviewActivity.java
./com/google/android/gms/tagmanager/TagManager.java
./com/google/android/gms/tagmanager/v.java
./com/google/android/gms/tagmanager/y.java
./com/google/android/gms/wearable/DataMapItem.java
./com/google/android/gms/wearable/internal/ad.java
./com/google/android/gms/wearable/internal/ae.java
./com/google/android/gms/wearable/internal/af.java
./com/google/android/gms/wearable/internal/ag.java
./com/google/android/gms/wearable/internal/f.java
./com/google/gson/DefaultDateTypeAdapter.java
./com/google/gson/Gson.java
./com/google/gson/internal/bind/DateTypeAdapter.java
./com/google/gson/internal/bind/ReflectiveTypeAdapterFactory.java
./com/google/gson/internal/bind/SqlDateTypeAdapter.java
./com/google/gson/internal/bind/TimeTypeAdapter.java
./com/google/gson/internal/bind/TypeAdapters.java
./com/google/gson/internal/Streams.java
./com/google/gson/JsonParser.java
./com/google/gson/JsonStreamParser.java
./com/parallel6/captivereachconnectsdk/cache/CRDynamicContentDao.java
./com/parallel6/captivereachconnectsdk/models/CRImage.java
./com/parallel6/captivereachconnectsdk/network/GetDynamicContent.java
./com/parallel6/captivereachconnectsdk/network/request/CaptiveReachRequest.java
./com/parallel6/captivereachconnectsdk/network/request/NetworkHelper.java
./com/parallel6/captivereachconnectsdk/utils/AsyncTask.java
./com/parallel6/captivereachconnectsdk/utils/StringUtils.java
./com/parallel6/ui/database/my_calendar/CalendarDao.java
./com/parallel6/ui/fragments/factories/CRDetailFragmentFactory.java
./com/parallel6/ui/widgets/calendar/CalendarPickerView.java
./gov/dhs/mobile/efoia/MainActivity.java
./gov/dhs/mobile/efoia/tasks/GetFormIDTask.java
./io/fabric/sdk/android/Fabric.java
./io/fabric/sdk/android/FabricKitsFinder.java
./io/fabric/sdk/android/Onboarding.java
./io/fabric/sdk/android/services/cache/AbstractValueCache.java
./io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy.java
./io/fabric/sdk/android/services/common/ApiKey.java
./io/fabric/sdk/android/services/common/CommonUtils.java
./io/fabric/sdk/android/services/common/IdManager.java
./io/fabric/sdk/android/services/common/QueueFile.java
./io/fabric/sdk/android/services/common/TimingMetric.java
./io/fabric/sdk/android/services/concurrency/AsyncTask.java
./io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.java
./io/fabric/sdk/android/services/events/EnabledEventsStrategy.java
./io/fabric/sdk/android/services/events/QueueFileEventStorage.java
./io/fabric/sdk/android/services/network/HttpRequest.java
./io/fabric/sdk/android/services/network/PinningTrustManager.java
./io/fabric/sdk/android/services/network/SystemKeyStore.java
./io/fabric/sdk/android/services/settings/AbstractAppSpiCall.java
./io/fabric/sdk/android/services/settings/DefaultCachedSettingsIo.java
./io/fabric/sdk/android/services/settings/DefaultSettingsController.java
./io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall.java
./io/fabric/sdk/android/services/settings/Settings.java
./org/apache/http/concurrent/BasicFuture.java
./org/apache/http/entity/BasicHttpEntity.java
./org/apache/http/entity/FileEntity.java
./org/apache/http/entity/InputStreamEntity.java
./org/apache/http/entity/mime/content/FileBody.java
./org/apache/http/entity/mime/content/InputStreamBody.java
./org/apache/http/impl/DefaultConnectionReuseStrategy.java
./org/apache/http/impl/entity/StrictContentLengthStrategy.java
./org/apache/http/impl/io/ChunkedInputStream.java
./org/apache/http/impl/io/ContentLengthInputStream.java
./org/apache/http/message/BasicLineParser.java
./org/apache/http/pool/AbstractConnPool.java
./org/apache/http/pool/PoolEntry.java
./org/apache/http/pool/PoolEntryFuture.java
./org/apache/http/protocol/HttpRequestExecutor.java
./org/apache/http/protocol/HttpService.java
./org/apache/http/protocol/UriPatternMatcher.java
./org/apache/http/util/EntityUtils.java
./org/apache/http/util/VersionInfo.java
./README.md

