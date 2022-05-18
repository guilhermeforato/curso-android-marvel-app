package com.example.marvelapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.marvelapp.R
import com.example.marvelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        navController = navHostFragment.navController
        binding.bottomNavMain.setupWithNavController(navController) // 1- seta as navegacoes do bottomNavigate com o navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.charactersFragment,// 3- esse bloco seta apenas o "startDestinations", para nao mostrar a seta de voltar na toolbar
                R.id.favoritesFragment,
                R.id.aboutFragment
            )
        )

        binding.toolbar.setupWithNavController(navController, appBarConfiguration) // 2- seta as configuracoes de navegacao para a toolbar

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            val isTopLevelDestination = appBarConfiguration.topLevelDestinations.contains(destination.id)
            if (!isTopLevelDestination) {
                binding.toolbar.setNavigationIcon(R.drawable.ic_back)
            }// 4- esse codigo esconde o botao de voltar da toolbar de acordo com o array acima setado os start destinations.
        }
    }
}