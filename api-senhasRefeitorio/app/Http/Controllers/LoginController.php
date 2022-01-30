<?php

namespace App\Http\Controllers;

use App\Models\Login;
use Illuminate\Http\Request;

class LoginController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {       

        $login = Login::get()->toJson(JSON_PRETTY_PRINT);
        return response($login, 200);
    }

    public function postLoginByEmailPassword(Request $request)
    {
      # code...
      $login = Login::where('email',$request->email)->where('password',$request->password)->first();
      return response($login, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        $login = new Login;
        $login->name = $request->name;
        $login->lastName = $request->lastName;
        $login->email = $request->email;
        $login->password = $request->password;
        $login->url = $request->url;
        $login->type = $request->type;
        $login->save();
    
        return response()->json([
            "message" => "User record created"
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
     * @param  \App\Models\Login  $login
     * @return \Illuminate\Http\Response
     */
    public function show($codUser)
    {
        if (Login::where('codUser', $codUser)->exists()) {
            $login = Login::where('codUser', $codUser)->get()->toJson(JSON_PRETTY_PRINT);
            return response($login, 200);
          } else {
            return response()->json([
              "message" => "Student not found"
            ], 404);
          }
      }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Login  $login
     * @return \Illuminate\Http\Response
     */
    public function edit(Login $login)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Login  $login
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request)
    {
        if (Login::where('codUser', $request->codUser)->exists()) {
            $login = Login::where('codUser', $request->codUser)->first();
            $login->name = is_null($request->name) ? $login->name : $request->name;
            $login->lastName = is_null($request->lastName) ? $login->lastName : $request->lastName;
            $login->email = is_null($request->email) ? $login->email : $request->email;
            $login->password = is_null($request->password) ? $login->password : $request->password;
            $login->url = is_null($request->url) ? $login->url : $request->url;
            $login->type = is_null($request->type) ? $login->type : $request->type;
            $login->save();
    
            return response()->json([
                "message" => "records updated successfully"
            ], 200);
            } else {
            return response()->json([
                "message" => "User not found"
            ], 404);
            
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Login  $login
     * @return \Illuminate\Http\Response
     */
    public function destroy($codUser)
    {
        if(Login::where('codUser', $codUser)->exists()) {
            $login = Login::where('codUser', $codUser);
            $login->delete();
    
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
