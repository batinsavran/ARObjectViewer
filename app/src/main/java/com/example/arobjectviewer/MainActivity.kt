package com.example.arobjectviewer

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.arobjectviewer.databinding.ActivityMainBinding
import com.google.ar.core.HitResult
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var arFragment: ArFragment
    private var modelRenderable: ModelRenderable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arFragment = supportFragmentManager.findFragmentById(binding.arFragment.id) as ArFragment

        loadModel()

        arFragment.setOnTapArPlaneListener { hitResult, _, _ ->
            onPlaneTap(hitResult)
        }
    }

    private fun loadModel() {
        ModelRenderable.builder()
            .setSource(this, Uri.parse("model.glb"))
            .build()
            .thenAccept { renderable ->
                modelRenderable = renderable
            }
            .exceptionally { throwable ->
                Log.e("MainActivity", "Error loading model: ${throwable.message}")
                null
            }
    }

    private fun onPlaneTap(hitResult: HitResult) {
        Log.d("ARSession", "Hit detected")

        if (modelRenderable == null) {
            Log.e("MainActivity", "Model renderable is null")
            return
        }

        val anchor = hitResult.createAnchor()
        val anchorNode = AnchorNode(anchor).apply {
            setParent(arFragment.arSceneView.scene)
        }

        TransformableNode(arFragment.transformationSystem).apply {
            setParent(anchorNode)
            renderable = modelRenderable
            select()
        }
    }

    override fun onResume() {
        super.onResume()
        arFragment.arSceneView.resume()
    }

    override fun onPause() {
        super.onPause()
        arFragment.arSceneView.pause()
    }
}
