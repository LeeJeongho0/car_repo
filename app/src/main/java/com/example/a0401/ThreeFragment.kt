package com.example.a0401

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a0401.databinding.*


class ThreeFragment : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentThreeBinding
    lateinit var mainActivity: MainActivity
    lateinit var dataList: MutableList<DataList>
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(layoutInflater)
        dataList = mutableListOf<DataList>()

        dataList.add(DataList("벤틀리 컨티넨탈GT","가격 33,200~38,400만원","출력 550hp",
            "엔진 V8 트윈터보",R.drawable.bencongt))
        dataList.add(DataList("벤틀리 컨티넨탈GT 컨버터블","가격 30,000만원","출력 650hp",
            "엔진 W12",R.drawable.bencongtcon))
        dataList.add(DataList("벤틀리 플라잉스퍼","가격 33,300~34,700만원","출력 550hp",
            "엔진 V8 트윈터보",R.drawable.benflyingspur))
        dataList.add(DataList("벤틀리 벤테이가","가격 29,600~30,500만원","출력 550hp",
            "엔진V8 트윈터보",R.drawable.benbentaeiga))
        dataList.add(DataList("벤틀리 뮬산","가격 40,000만원~","출력 505hp",
            "엔진 V8 트윈터보",R.drawable.benmulsanne))
        dataList.add(DataList("벤틀리 뮬리너 바투르","가격 1,950,000달러","출력 730hp",
            "엔진 W12",R.drawable.benmullinerbatur))

        binding.recyclerview.adapter = CustomRecyclerViewAdapter(dataList)
        binding.recyclerview.layoutManager = LinearLayoutManager(mainActivity)
        binding.btnChoice.setOnClickListener(this)
        binding.btnFAB.setOnClickListener(this)


        return binding.root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnChoice -> {
                val userBinding: ChoiceLayoutBinding
                val dialogBuilder = AlertDialog.Builder(mainActivity)
                val userDialog: AlertDialog

                userBinding = ChoiceLayoutBinding.inflate(layoutInflater)
                dialogBuilder.setView(userBinding.root)
                userDialog = dialogBuilder.create()
                userDialog.show()

                userBinding.btnCancel.setOnClickListener {
                    Toast.makeText(mainActivity,"취소합니다", Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }
                userBinding.btnRegister.setOnClickListener {
                    Toast.makeText(mainActivity,"등록", Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }
            }
            R.id.btnFAB -> {
                var bindingDialog: DialogCustomBinding
                val dialogBuilder = AlertDialog.Builder(requireContext())
                var userDialog: AlertDialog
                bindingDialog = DialogCustomBinding.inflate(layoutInflater)
                dialogBuilder.setView(bindingDialog.root)
                userDialog = dialogBuilder.create()
                userDialog.show()

                bindingDialog.btnCancel.setOnClickListener {
                    userDialog.dismiss()
                }
                bindingDialog.btnSave.setOnClickListener {
                    val newData = DataList(
                        bindingDialog.edtName.text.toString(),
                        bindingDialog.edtPrice.text.toString(),
                        bindingDialog.edtPower.text.toString(),
                        bindingDialog.edtEngine.text.toString(),
                        R.drawable.bencongt
                    )
                    binding.recyclerview.adapter?.notifyDataSetChanged()
                    dataList.add(newData)
                    Toast.makeText(requireContext(), "등록이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }
            }
        }
    }
}