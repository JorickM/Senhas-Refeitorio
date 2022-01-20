<?php

namespace App\Http\Controllers;

use App\Models\mealtype;
use Illuminate\Http\Request;

class MealTypeController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $mealType = mealType::get()->toJson(JSON_PRETTY_PRINT);
        return response($mealType, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        //
        $mealType = new mealType;
        $mealType->codMealType = $request->codMealType;
        $mealType->name = $request->name;
        $mealType->save();

        return response()->json([
            "message" => "meal record created"
        ], 201);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\mealtype  $mealtype
     * @return \Illuminate\Http\Response
     */
    public function show($codMealType)
    {
        //
        if (mealType::where('codMealType', $codMealType)->exists()) {
            $mealType = mealType::where('mealType', $mealType)->get()->toJson(JSON_PRETTY_PRINT);
            return response($mealType, 200);
          } else {
            return response()->json([
              "message" => "mealType not found"
            ], 404);
        }
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\mealtype  $mealtype
     * @return \Illuminate\Http\Response
     */
    public function edit(mealtype $mealtype)
    {
        //
        
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\mealtype  $mealtype
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $codMealType)
    {
        //
        if (mealtype::where('codMealType', $codMealType)->exists()) {
            $codMealType = codMealType::find($codMealType);
            $codMealType->name = is_null($request->name) ? $codMealType->desert : $request->name;
            $codMealType->save();
    
            return response()->json([
                "message" => "records updated successfully"
            ], 200);
            } else {
            return response()->json([
                "message" => "codMealType not found"
            ], 404);
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\mealtype  $mealtype
     * @return \Illuminate\Http\Response
     */
    public function destroy($codMealType)
    {
        //
        if(mealtype::where('codMealType', $codMealType)->exists()) {
            $codMealType = codMealType::find($codMealType);
            $codMealType->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "codMealType not found"
            ], 404);
          }
    }
}
