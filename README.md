# Retrofit 1.x系の導入/設計

## 参考

- http://square.github.io/retrofit/
- http://blog.robinchutaux.com/blog/a-smart-way-to-use-retrofit/
- https://github.com/rallat/EffectiveAndroid/tree/mvp
- http://blog.nkzn.info/entry/2013/01/01/235154
- https://gist.github.com/Nkzn/4427906

## NOTE

- MVP
- ModelはAPIの通信に限らず, 様々なデータを扱うメソッドを持ち、Entityを返す
- PresenterはViewとModelを扱うメソッドを持ちModelからEntityを受け取り、Viewに渡したりする
- Viewは, Viewに関するメソッドを持ち、Entityを利用して表示したりする
