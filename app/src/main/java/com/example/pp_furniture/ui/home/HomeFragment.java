package com.example.pp_furniture.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.pp_furniture.R;
import com.example.pp_furniture.databinding.FragmentHomeBinding;
import com.example.pp_furniture.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    List<CategoryModel> list_category = new ArrayList<>();
    CategoryAdapter adapter;
    LottieAnimationView lotty_sale, lotty_sool;
    NavController navController;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        lotty_sale = binding.lottySale;
        lotty_sale.setAnimation(R.raw.furniture);
        lotty_sool = binding.lottySool;
        lotty_sool.setAnimation(R.raw.sool);
        lotty_sool.setRepeatCount(LottieDrawable.INFINITE);


        createList();
        adapter = new CategoryAdapter();
        adapter.setMain_list(list_category);
        binding.rvCatalogCategory.setAdapter(adapter);

        return root;
    }

    private void createList() {
        list_category.add(new CategoryModel("Для спальни", R.drawable.img));
        list_category.add(new CategoryModel("Для гостинной",R.drawable.divan_krovat_spark));
        list_category.add(new CategoryModel("Кухонная мебель", R.drawable.lagos_kukhnya_3_01));
        list_category.add(new CategoryModel("Садовая мебель", R.drawable.sad));
        list_category.add(new CategoryModel("Мебель для прихожей",R.drawable.prichojka));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.saleCardView.setOnClickListener(v->{
            navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_navigation_home_to_saleFragment);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}