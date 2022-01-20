<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;

class UserController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $user = purchase::get()->toJson(JSON_PRETTY_PRINT);
        return response($user, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        //
        $user = new user;
        $user->name = $request->name;
        $user->lastname = $request->lastname;
        $user->email = $request->email;
        $user->password = $request->password;
        $user->url = $request->url;
        $user->type = $request->type;
        $user->save();

        return response()->json([
            "message" => "user record created"
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
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function show($codUser)
    {
        //
        if (user::where('codUser', $codUser)->exists()) {
            $user = user::where('codUser', $codUser)->get()->toJson(JSON_PRETTY_PRINT);
            return response($user, 200);
            } else {
            return response()->json([
                "message" => "user not found"
            ], 404);
        }
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function edit(User $user)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $codUser)
    {
        //
        if (user::where('codUser', $codUser)->exists()) {
            $user = purchase::find($codPurchase);
            $user->name = is_null($request->name) ? $purchase->name : $request->name;
            $user->lastname = is_null($request->lastname) ? $purchase->lastname : $request->lastname;
            $user->email = is_null($request->email) ? $purchase->email : $request->email;
            $user->password = is_null($request->password) ? $purchase->password : $request->password;           
            $user->url = is_null($request->url) ? $purchase->url : $request->url;
            $user->type = is_null($request->type) ? $purchase->type : $request->type;
            $user->save();

            return response()->json([
                "message" => "records updated successfully"
            ], 200);
            } else {
            return response()->json([
                "message" => "user not found"
            ], 404);
        }    
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function destroy($codUser)
    {
        //
        if(user::where('codUser', $codUser)->exists()) {
            $user = user::find($codUser);
            $user->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "user not found"
            ], 404);
          } 
    }
}
