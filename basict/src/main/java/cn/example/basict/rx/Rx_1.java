package cn.example.basict.rx;

/**
 * Author：created by SugarT
 * Time：2019/10/29 15
 */


import cn.example.basict.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 创建被观察者的各种操作符。
 */
public class Rx_1 {

    public static void main(String args[]) {
//        create();
    }

    public static void create() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) {
                //Emitter发射极
                e.onNext("Hello Observer");
                e.onComplete();
            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d("chan", "=============onNext " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("chan", "=============onComplete ");
            }
        };
        observable.subscribe(observer);

        Observable.just(1,2,3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer s) {
                Log.d("chan", "=============onNext " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("chan", "=============onComplete ");
            }
        });



        Observable.fromArray(1,2,3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer s) {
                Log.d("chan", "=============onNext " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("chan", "=============onComplete ");
            }
        });
    }






}
