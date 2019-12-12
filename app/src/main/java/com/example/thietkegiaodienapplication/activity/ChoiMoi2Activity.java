package com.example.thietkegiaodienapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.dao.CauHoiDAO;
import com.example.thietkegiaodienapplication.dao.NhanVatDAO;
import com.example.thietkegiaodienapplication.dao.UserDAO;
import com.example.thietkegiaodienapplication.database.UserDatabase;
import com.example.thietkegiaodienapplication.model.CauHoi;
import com.example.thietkegiaodienapplication.model.Check;
import com.example.thietkegiaodienapplication.model.NhanVat;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class ChoiMoi2Activity extends AppCompatActivity {
    Button btna, btnb, btnc, btnd;
    public static int luotchoi = 3;
    List<NhanVat> nhanVats;
   NhanVatDAO nhanVatDAO;
    TextView tvcauhoi, tvthoigian, tvdiem, tvlever, tvluotchoi, tvsoluongcauhoi;
    List<CauHoi> cauHois;
    CauHoiDAO cauHoiDAO;
    public int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_moi2);
        btna = findViewById(R.id.btna);
        btnb = findViewById(R.id.btnb);
        btnc = findViewById(R.id.btnc);
        btnd = findViewById(R.id.btnd);
        tvcauhoi = findViewById(R.id.tvcauhoi);
        tvthoigian = findViewById(R.id.tvtime);
        tvdiem = findViewById(R.id.tvdiem);
        tvlever = findViewById(R.id.tvlever);
        tvluotchoi = findViewById(R.id.tvluotchoi);
        tvsoluongcauhoi = findViewById(R.id.tvslcauhoi);
       nhanVats=new ArrayList<>();
       nhanVatDAO=new NhanVatDAO(ChoiMoi2Activity.this);
        cauHois = new ArrayList<>();
        cauHoiDAO = new CauHoiDAO(this);
        cauHois = cauHoiDAO.getAll();

        code = (int) Math.floor(((Math.random() * (cauHois.size() - 1)) + 0));

        tvsoluongcauhoi.setText(MainActivity.cauhoi + "/30");
        tvdiem.setText(String.valueOf(MainActivity.diem));
        tvluotchoi.setText(String.valueOf(luotchoi));
        for (int i = 0; i < MainActivity.checks.size(); i++) {
            if (code == MainActivity.checks.get(i).abc) {
                code = (int) Math.floor(((Math.random() * (cauHois.size() - 1)) + 0));
                i = 0;
            }
        }
        Check check = new Check();
        check.abc = code;
        MainActivity.checks.add(check);
        if (MainActivity.checks.size() == cauHois.size()) {
            MainActivity.checks = new ArrayList<>();

        }
        tvcauhoi.setText(cauHois.get(code).getCauhoi());
        btna.setText(cauHois.get(code).getDapan_a());
        btnb.setText(cauHois.get(code).getDapan_b());
        btnc.setText(cauHois.get(code).getDapan_c());
        btnd.setText(cauHois.get(code).getDapan_d());

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btna.getText().equals(cauHois.get(code).cautraloidung)) {
                    Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                    dialogdung();


                } else {
                    Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                    dialogsai();
                }

            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnb.getText().equals(cauHois.get(code).cautraloidung)) {
                    Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                    dialogdung();


                } else {
                    Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                    dialogsai();
                }

            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnc.getText().equals(cauHois.get(code).cautraloidung)) {
                    Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                    dialogdung();

                } else {
                    Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                    dialogsai();
                }

            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnd.getText().equals(cauHois.get(code).cautraloidung)) {
                    Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                    dialogdung();

                } else {
                    Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                    dialogsai();
                }

            }
        });
    }

    public void dialogdung() {
        final Dialog dialog = new Dialog(ChoiMoi2Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialongdung);
        final Button btnnghi = dialog.findViewById(R.id.btnnghigame);
        final Button btnchoitiep = dialog.findViewById(R.id.btnchoitiep);

        btnnghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnchoitiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = (int) Math.floor(((Math.random() * (cauHois.size() - 1)) + 0));
                MainActivity.cauhoi++;
                MainActivity.diem += 10;
                tvsoluongcauhoi.setText(MainActivity.cauhoi + "/30");
                tvdiem.setText(String.valueOf(MainActivity.diem));
                tvluotchoi.setText(String.valueOf(luotchoi));
                for (int i = 0; i < MainActivity.checks.size(); i++) {
                    if (code == MainActivity.checks.get(i).abc) {
                        code = (int) Math.floor(((Math.random() * (cauHois.size() - 1)) + 0));
                        i = 0;
                    }
                }
                Check check = new Check();
                check.abc = code;
                MainActivity.checks.add(check);
                if (MainActivity.checks.size() == cauHois.size()) {
                    MainActivity.checks = new ArrayList<>();

                }
                tvcauhoi.setText(cauHois.get(code).getCauhoi());
                btna.setText(cauHois.get(code).getDapan_a());
                btnb.setText(cauHois.get(code).getDapan_b());
                btnc.setText(cauHois.get(code).getDapan_c());
                btnd.setText(cauHois.get(code).getDapan_d());

                btna.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btna.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();


                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                btnb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnb.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();


                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                btnc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnc.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();

                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                btnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnd.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();

                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void dialogsai() {
        final Dialog dialog = new Dialog(ChoiMoi2Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialongsai);
        final Button btnnghi = dialog.findViewById(R.id.btnthoatdialog2);
        final Button btnchoitiep = dialog.findViewById(R.id.btnchoitiep2);

        btnnghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnchoitiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = (int) Math.floor(((Math.random() * (cauHois.size() - 1)) + 0));
                MainActivity.cauhoi++;
                MainActivity.diem -= 10;
                luotchoi -= 1;
                if (luotchoi == -1) {
                    final Dialog tinhdiem = new Dialog(ChoiMoi2Activity.this);
                    tinhdiem.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    tinhdiem.setContentView(R.layout.luudiem);
                    final Button btnluudiem = tinhdiem.findViewById(R.id.btn_tinhDiem);
                    final TextView tvdiemcuaban = tinhdiem.findViewById(R.id.tvdiemdialog);
                    final EditText edtnamenv = tinhdiem.findViewById(R.id.edt_namenv);
                    tvdiemcuaban.setText(String.valueOf(MainActivity.diem));
                    btnluudiem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String namenv= edtnamenv.getText().toString().trim();
                            int diemnv= MainActivity.diem;



                            if(namenv.isEmpty()){
                                Toast.makeText(ChoiMoi2Activity.this, "Nhapj ten vao dcm", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                NhanVat nhanVat = new NhanVat();
                                nhanVat.namenv=namenv;
                                nhanVat.diem=diemnv;
                                nhanVats.add(nhanVat);
                                long re = nhanVatDAO.insert(nhanVat);
                                if(re>0){
                                    Toast.makeText(ChoiMoi2Activity.this, "thanh cong", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(ChoiMoi2Activity.this, "That bai", Toast.LENGTH_SHORT).show();
                                }
                            }


                        }
                    });

                    tinhdiem.show();
                }
                tvsoluongcauhoi.setText(MainActivity.cauhoi + "/30");
                tvdiem.setText(String.valueOf(MainActivity.diem));
                tvluotchoi.setText(String.valueOf(luotchoi));
                for (int i = 0; i < MainActivity.checks.size(); i++) {
                    if (code == MainActivity.checks.get(i).abc) {
                        code = (int) Math.floor(((Math.random() * (cauHois.size() - 1)) + 0));
                        i = 0;
                    }
                }
                Check check = new Check();
                check.abc = code;
                MainActivity.checks.add(check);
                if (MainActivity.checks.size() == cauHois.size()) {
                    MainActivity.checks = new ArrayList<>();

                }
                tvcauhoi.setText(cauHois.get(code).getCauhoi());
                btna.setText(cauHois.get(code).getDapan_a());
                btnb.setText(cauHois.get(code).getDapan_b());
                btnc.setText(cauHois.get(code).getDapan_c());
                btnd.setText(cauHois.get(code).getDapan_d());

                btna.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btna.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();


                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                btnb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnb.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();


                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                btnc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnc.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();

                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                btnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnd.getText().equals(cauHois.get(code).cautraloidung)) {
                            Toast.makeText(ChoiMoi2Activity.this, "Dung", Toast.LENGTH_SHORT).show();
                            dialogdung();

                        } else {
                            Toast.makeText(ChoiMoi2Activity.this, "Sai", Toast.LENGTH_SHORT).show();
                            dialogsai();

                        }

                    }
                });
                dialog.dismiss();
            }
        });
        dialog.show();

    }



}
