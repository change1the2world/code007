package com.example.mt.custom

/**
 *Time:2019/5/31
 *Author:zyh
 *Description:
 */
//abstract class RealCallback<T>(serializator: IGenericsSerializator?,context: Context)
//    : GenericsCallback<T>(serializator) {
//    private var context : Context? = context
//    private var dialog : Dialog? = null
//    private lateinit var anim : AnimationDrawable
//    override fun onBefore(request: Request?, id: Int) {
//        super.onBefore(request, id)
//        showDialog()
//    }
//    override fun onResponse(response: T, id: Int) {
//        onSuccess(response, id)
//    }
//    override fun onError(call: Call?, e: Exception?, id: Int) {
//        onFailure(call, e, id)
//    }
//    override fun onAfter(id: Int) {
//        super.onAfter(id)
//        dismissDialog()
//    }
//    private fun showDialog(){
//        val view = LayoutInflater.from(context)
//                .inflate(R.layout.dialog_loading, null)
//        val loading = view.findViewById<ImageView>(R.id.dialog_loading_progress)
//        anim = loading.drawable as AnimationDrawable
//        anim.start()
//        if (dialog == null){
//            dialog = Dialog(context,R.style.LoadDialog)
//            dialog!!.setContentView(view)
//            dialog!!.show()
//        }
//
//    }
//    private fun dismissDialog(){
//        if (dialog != null && dialog!!.isShowing){
//            dialog!!.dismiss()
//            anim.stop()
//        }
//    }
//    abstract fun onSuccess(response: T, id: Int)
//    abstract fun onFailure(call: Call?, e: Exception?, id: Int)
//    abstract fun onComplete(id: Int)
//}